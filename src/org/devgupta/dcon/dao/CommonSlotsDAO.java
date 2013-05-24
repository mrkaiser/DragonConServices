package org.devgupta.dcon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.devgupta.dcon.dao.wrappers.CommonSlotsDAOWrapper;
import org.devgupta.dcon.model.EventSlots;

import com.google.appengine.api.rdbms.AppEngineDriver;

/**
 * 
 * @author mrkaiser
 *
 */
public class CommonSlotsDAO extends CloudSQLDAO<EventSlots> {

	private final static String STATEMENT_FOR_COMMON_SLOTS = "select t1.date, t2.start_time, t2.end_time,t2.title,t2.type,t2.meta " +
			"from common_slots as t1 INNER JOIN common_time_slots as t2 ON t1.time_slot_id = t2.time_slot_id;";
	
	public CommonSlotsDAO(){
		super(STATEMENT_FOR_COMMON_SLOTS,new CommonSlotsDAOWrapper());
	}
	
}
