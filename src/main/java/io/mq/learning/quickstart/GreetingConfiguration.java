package io.mq.learning.quickstart;

import io.quarkus.arc.config.ConfigProperties;

import java.util.List;

@ConfigProperties(prefix = "greeting")
public class GreetingConfiguration {
    public String message;
    public String suffix = "!";
    public OutputConfiguration output;

    public static class OutputConfiguration { public List<String> recipients;
    }

}