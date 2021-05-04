package io.mq.learning.quickstart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/developer")
public class DeveloperResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        return Response.created(
                UriBuilder
                        .fromResource(DeveloperResource.class)
                        .path(Long.toString(developer.getId()))
                        .build()
        )
                .entity(developer)
                .build();
    }

    public static class Developer {
        static long counter = 1;
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void persist() {
            this.id = counter++;
        }
    }
}