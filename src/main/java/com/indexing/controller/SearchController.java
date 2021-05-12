package com.indexing.controller;

import com.indexing.exception.InvalidQueryException;
import com.indexing.service.SearchService;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created bu PacLab
 * User: PacLab
 */

@Path("/search")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SearchController {

    private SearchService searchService = new SearchService();


    @GET
    public Response findMatchingFiles(@QueryParam("keywords") String keywords, @QueryParam("table") String tables) {
        String[] splitKeywords = keywords.split(",");
        String[] splitTables = tables.split(",");
        String result =
                searchService
                        .search(Arrays.asList(splitKeywords), splitTables)
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(","));

        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    public Response searchByQuery(String query) throws InvalidQueryException {
        JSONArray result = searchService.search(query);
        return Response.status(Response.Status.OK).entity(result.toString()).build();
    }
}