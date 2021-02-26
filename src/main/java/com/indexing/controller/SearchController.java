package com.indexing.controller;

import com.indexing.exception.InvalidQueryExcepiton;
import com.indexing.service.SearchService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created bu PacLab
 * User: sami
 * */

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

    @GET
    public Response queryIndex(String query) throws InvalidQueryExcepiton {
        List<String> rows = searchService.search(query);
        String result = rows.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
        return Response.status(Response.Status.OK).entity(result).build();
    }
}
