package com.example.pwc.routing;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountriesParserTest {
    @Test
    public void checkParsing() {
        var countries = CountriesParser.readJson(new ClassPathResource("test-countries.json"));
        assertEquals(countries.size(), 2);
        assertEquals(countries.get(0).getName(), "ABW");
        assertEquals(countries.get(1).getBorders(), List.of("IRN", "PAK", "TKM", "UZB", "TJK", "CHN"));
    }
}
