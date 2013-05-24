package org.devgupta.dcon.dao;

import org.devgupta.dcon.dao.wrappers.DAOWrapper;
import org.devgupta.dcon.dao.wrappers.SearchSuggestWrapper;
import org.devgupta.dcon.model.SearchSuggestions;

public class SearchSuggestDAO extends CloudSQLDAO<SearchSuggestions> {
	
	private static final String STATEMENT = "select word from searchsuggest;";
	
	public SearchSuggestDAO() {
		super(STATEMENT, new SearchSuggestWrapper());
	}

}
