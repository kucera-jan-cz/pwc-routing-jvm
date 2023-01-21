package com.example.pwc.routing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Component
public class CountriesParser {
    private static final TypeReference<List<CountryInfo>> REFERENCE = new TypeReference<>() {
    };

    public static List<CountryInfo> readJson(ClassPathResource resource) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream stream = resource.getInputStream()) {
            return mapper.readValue(stream, REFERENCE);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
