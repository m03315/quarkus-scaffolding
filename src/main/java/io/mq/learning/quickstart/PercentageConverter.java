package io.mq.learning.quickstart;

import org.eclipse.microprofile.config.spi.Converter;

import javax.annotation.Priority;

@Priority(300)
public class PercentageConverter implements Converter<Percentage> {
    @Override
    public Percentage convert(String value) {
        String numeric = value.substring(0, value.length() -
                1);
        return new Percentage(Double.parseDouble(numeric) / 100);
    }
}
