package com.example.pwc.routing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
@Value
@AllArgsConstructor
public class RoutingResultDTO {
    List<String> route;
}
