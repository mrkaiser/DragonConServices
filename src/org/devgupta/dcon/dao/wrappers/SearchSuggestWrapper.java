package org.devgupta.dcon.dao.wrappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.devgupta.dcon.model.SearchSuggestions;

import com.google.appengine.labs.repackaged.com.google.common.collect.ImmutableList;

public class SearchSuggestWrapper implements DAOWrapper<SearchSuggestions> {
	
	
	@Override
	public SearchSuggestions wrapResultSet(ResultSet set) throws SQLException {
		ImmutableList.Builder<String> builder = ImmutableList.builder();
		while(set.next()){
			builder.add(set.getString("word"));
		}
		SearchSuggestions suggestion = new SearchSuggestions();
		suggestion.words = builder.build().toArray(new String[0]);
		return suggestion;
	}

}
