package io.mq.learning.quickstart;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//Identifies the URI path of the current resource
@Path("/hello")
public class GreetingResource {

    //Responds to HTTP GET requests
    @GET
    //Defines the media type(s) that are returned
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        //Returns plain text
        return "hello";
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String message) {
        System.out.println("Create");
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        System.out.println("Update");
        return message;
    }

    @DELETE
    public void delete() {
        System.out.println("Delete");
    }

}