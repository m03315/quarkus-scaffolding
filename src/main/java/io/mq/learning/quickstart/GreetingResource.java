package io.mq.learning.quickstart;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.lang.annotation.*;
import java.util.List;

//Identifies the URI path of the current resource
@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.upper-case",
            defaultValue = "true")
    boolean upperCase;

    @Inject
    Config config;
    //ConfigProvider.getConfig()

    @ConfigProperty(name = "greeting.color")
    String color;

    @GET
    @Path("/color")
    @Produces(MediaType.TEXT_PLAIN)
    public String color() {
        return color;
    }

    private static org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(GreetingResource.class);

    public static enum Order {
        desc, asc;
    }

    @GET
    @Path("/log")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloLog() {
        logger.info("I said Hello");
        return "hello";
    }


    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        config.getPropertyNames().forEach(p ->
                System.out.println(p));
        return config.getValue("greeting.message", String.class);
    }


    @GET
    @Path("/optional")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloOptional() {
        return upperCase ? message.toUpperCase() : message;
    }

    @ConfigProperty(name = "greeting.suffix")
    List<String> suffixes;

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloList() {
        return message + suffixes.get(1);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message;
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
        return id + " locked";
    }

}