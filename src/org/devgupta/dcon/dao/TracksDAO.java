package org.devgupta.dcon.dao;

import org.devgupta.dcon.dao.wrappers.TracksWrapper;
import org.devgupta.dcon.model.Tracks;

public class TracksDAO extends CloudSQLDAO<Tracks> {
	public static final String STATEMENT = "select name,color,abstract from tracks;";
	
	public TracksDAO(){
		super(STATEMENT, new TracksWrapper());
	}
}
