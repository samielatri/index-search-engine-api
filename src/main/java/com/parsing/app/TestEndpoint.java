package com.parsing.app;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/10/2021
 * Time: 3:55 PM
 * Package: app
 */
    @Path("/api/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class TestEndpoint {

        @GET
        @Produces(MediaType.TEXT_HTML)
        public String helloWorld() {
            return "Hello World";
        }

        @GET
        @Path("/list")
        public List<String> getListInParams(@QueryParam("ids") List<String> ids) {
            System.out.println(ids);
            return ids;
        }

       // @POST
       // @Path("/entity")
        //public Account getAccount(Account account) {
        //    System.out.println("Received account " + account);
        //    account.setUpdated(System.currentTimeMillis());
         //   return account;
        //}

        @GET
        @Path("/exception")
        public Response exception() {
            throw new RuntimeException("Mon erreur");
        }

    }
