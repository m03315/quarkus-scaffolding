package io.mq.learning.quickstart;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.lang.annotation.*;

//Identifies the URI path of the current resource
@Path("/hello")
public class GreetingResource {

    public static enum Order{
        desc, asc;
    }

    //Responds to HTTP GET requests
    @GET
    //Defines the media type(s) that are returned
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") Order order,
            @NotBlank @HeaderParam("authorization") String authorization) {
        //Returns plain text
        return String.format("URI: %s - Order %s - Authorization: %s", uriInfo.getAbsolutePath(),
                order,authorization);
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

    @LOCK
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id) {
        return id + " locked"; }

}