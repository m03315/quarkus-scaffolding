package io.mq.learning.quickstart;

import io.vertx.ext.web.Router;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {

    public void routes(@Observes Router router) {
        router.get("/ok")
                .handler(rc -> rc.response().end("OK from Route"));

    }
}
