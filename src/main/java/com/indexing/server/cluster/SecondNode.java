package com.indexing.server.cluster;

import com.indexing.server.HasEndPoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public class SecondNode implements HasEndPoints {

    public SecondNode() {}

    @GET
    @Path("/second-node")
    public String getSecondNode(@Context UriInfo uriInfo)
            throws Exception{
        return "-- Second Node";
    }

    @GET
    @Path("/exception")
    public Response getException() {
        throw new RuntimeException("Exception Thrown");
    }

}
