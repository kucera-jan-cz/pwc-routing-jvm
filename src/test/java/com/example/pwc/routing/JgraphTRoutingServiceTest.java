package com.example.pwc.routing;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JgraphTRoutingServiceTest {
    @Test
    public void checkPath() {
        var countries = CountriesParser.readJson(new ClassPathResource("countries.json"));
        var service = new JgraphTRoutingService(countries);
        var result = service.find("CZE", "ITA");
        assertEquals(result, List.of("CZE", "AUT", "ITA"));
    }
}
