package io.mq.learning.quickstart;

import io.quarkus.arc.config.ConfigProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@ConfigProperties(prefix = "greeting")
public class GreetingConfiguration {
    public String message;
    public String suffix = "!";
    public OutputConfiguration output;
    @Min(1)
    @Max(3)
    public Integer repeat;

    public static class OutputConfiguration { public List<String> recipients;
    }

}