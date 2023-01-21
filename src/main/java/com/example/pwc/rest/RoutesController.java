package com.example.pwc.rest;


import com.example.pwc.commons.Validations;
import com.example.pwc.routing.IRoutingService;
import com.example.pwc.routing.RoutingResultDTO;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/routing")
@AllArgsConstructor
public class RoutesController {
    private static final String UNKNOWN_VERSION = "UNKNOWN";
    private final IRoutingService routingService;

    @GetMapping("/version")
    public String getStatus() {
        try {
            var version = this.getClass().getPackage().getImplementationVersion();
            return StringUtils.hasLength(version) ? version : UNKNOWN_VERSION;
        } catch (RuntimeException ex) {
            return UNKNOWN_VERSION;
        }
    }

    @GetMapping("/{origin}/{destination}")
    public RoutingResultDTO getBoarders(@PathVariable String origin, @PathVariable String destination) {
        var routes = Validations.notNull(routingService.find(origin, destination), "No route found for given origin and destination");
        return new RoutingResultDTO(routes);
    }

}
