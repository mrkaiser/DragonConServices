package org.devgupta.dcon.resources;



import java.sql.SQLException;
import java.util.logging.Logger;

import org.devgupta.dcon.dao.SearchSuggestDAO;
import org.devgupta.dcon.dao.TracksDAO;
import org.devgupta.dcon.model.SearchSuggestions;
import org.devgupta.dcon.model.Tracks;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.gson.Gson;

@Api(name="models")
public class ModelResource {
	Gson gson = new Gson();
	private static final Logger log = Logger.getLogger(ModelResource.class.getName());

	@ApiMethod(name="tracks",path="tracks/get",httpMethod=HttpMethod.GET)
	public Tracks getTracks() throws SQLException{
		TracksDAO dao = new TracksDAO();
		return dao.executeQuery();
	}
	
	@ApiMethod(name="searchsuggest",path="searchsuggest/get",httpMethod=HttpMethod.GET)
	public SearchSuggestions getSuggestions() throws SQLException{
		log.info("Entering Search Suggestions");
		SearchSuggestDAO dao = new SearchSuggestDAO();
		return dao.executeQuery();
	}
	
	@ApiMethod(name="test",path="test/get",httpMethod=HttpMethod.GET)
	public SearchSuggestions getTest() {
		String[] test = new String[] {"blah"};
		SearchSuggestions returnable = new SearchSuggestions();
		returnable.words = test;
		return returnable;
	}


}
