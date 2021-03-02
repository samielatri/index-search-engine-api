package com.indexing.controller;

import com.indexing.exception.InvalidQueryExcepiton;
import com.indexing.service.SearchService;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SearchController {

    private SearchService searchService = new SearchService();


    @GET
    public Response findMatchingFiles(@QueryParam("keywords") String keywords) {
        String[] splitKeywords = keywords.split(",");
        String result =
                searchService
                        .search(Arrays.asList(splitKeywords))
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(","));

        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    public Response searchByQuery(String query) throws InvalidQueryExcepiton {
        JSONArray result = searchService.search(query);
        return Response.status(Response.Status.OK).entity(result.toString()).build();
    }
}