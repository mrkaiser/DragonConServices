package org.devgupta.dcon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.devgupta.dcon.dao.wrappers.DAOWrapper;

import com.google.appengine.api.rdbms.AppEngineDriver;

/**
 * DAOs can follow the Template Method Design Pattern
 * 
 * @author mrkaiser
 * 
 */
public abstract class CloudSQLDAO<T> {
	
	protected final String statement;
	protected final DAOWrapper<T> wrapper;
	
	
	
	protected CloudSQLDAO(String statement,DAOWrapper<T> wrapper) {
		this.statement = statement;
		this.wrapper = wrapper;
	}


	public final T executeQuery() throws SQLException {
		ResultSet returnableResults = null;
		Connection c = null;
		T returnable = null;
		try {
			c = buildDriverAndRetrieveConnection();
			PreparedStatement statement = generatePreparedStatementUsingConnection(c);
			returnableResults = executePreparedStatementForQuery(statement);
			returnable = wrapper.wrapResultSet(returnableResults);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return returnable;
	}

	protected Integer executeUpdate() throws SQLException {
		Connection c = buildDriverAndRetrieveConnection();
		PreparedStatement statement = generatePreparedStatementUsingConnection(c);
		Integer returnableExecutionCode = executePreparedStatementForUpdate(statement);
		return returnableExecutionCode;

	}

	

	protected ResultSet executePreparedStatementForQuery(
			PreparedStatement preparedStatement) throws SQLException {
		ResultSet returnableSet = preparedStatement.executeQuery();
		return returnableSet;
	}

	protected PreparedStatement generatePreparedStatementUsingConnection(
			Connection c) throws SQLException {
		PreparedStatement statement = c.prepareStatement(this.statement);
		return statement;
	}
	
	protected Integer executePreparedStatementForUpdate(
			PreparedStatement preparedStatement) {
		return 0;
	}

	protected Connection buildDriverAndRetrieveConnection() throws SQLException {
		//build and register driver
		DriverManager.registerDriver(new AppEngineDriver());
		Connection conn = DriverManager.getConnection("jdbc:google:rdbms://dragoncon2013:dcontwenty/dbcondb");
		return conn;
	}

}
