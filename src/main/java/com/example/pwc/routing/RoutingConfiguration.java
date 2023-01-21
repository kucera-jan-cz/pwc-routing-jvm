package com.example.pwc.routing;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@Configuration
public class RoutingConfiguration {
    @Bean
    public List<CountryInfo> countries() {
        return CountriesParser.readJson(new ClassPathResource("countries.json"));
    }
}
