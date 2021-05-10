package io.mq.learning.quickstart;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;

public class InMemoryConfigSource implements ConfigSource {
    private Map<String, String> prop = new HashMap<>();

    public InMemoryConfigSource() {
        prop.put("greeting.color", "red");
    }

    @Override
    public int getOrdinal() {
        return 500;
    }

    @Override
    public Map<String, String> getProperties() {
        return prop;
    }

    @Override
    public String getValue(String propertyName) {
        return prop.get(propertyName);
    }

    @Override
    public String getName() {
        return "MemoryConfigSource";
    }
}
