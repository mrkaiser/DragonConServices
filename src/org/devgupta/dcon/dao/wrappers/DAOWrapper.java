/**
 * 
 */
package org.devgupta.dcon.dao.wrappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author mrkaiser
 *
 */
public interface  DAOWrapper<T> {
	
	abstract public T wrapResultSet(ResultSet set) throws SQLException;

}
