package org.devgupta.dcon.dao.wrappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.devgupta.dcon.model.SearchSuggestions;
import org.devgupta.dcon.model.Track;
import org.devgupta.dcon.model.Tracks;

import com.google.appengine.labs.repackaged.com.google.common.collect.ImmutableList;

public class TracksWrapper implements DAOWrapper<Tracks> {

	@Override
	public Tracks wrapResultSet(ResultSet set) throws SQLException {
		ImmutableList.Builder<Track> builder = ImmutableList.builder();
		Track mutableTrack;
		while(set.next()){
			mutableTrack = new Track();
			mutableTrack.name = set.getString("name");
			mutableTrack.color = set.getString("color");
			mutableTrack._abstract = set.getString("abstract");
			builder.add(mutableTrack);
		}
		Tracks tracks = new Tracks();
		tracks.track = builder.build().toArray(new Track[0]);
		return tracks;
	}

}
