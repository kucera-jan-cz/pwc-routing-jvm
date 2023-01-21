package com.example.pwc.routing;

import com.example.pwc.commons.Validations;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JgraphTRoutingService implements IRoutingService {
    private final List<String> availableCountries;
    private final Graph<String, DefaultEdge> graph;
    private final DijkstraShortestPath<String, DefaultEdge> dijkstraAlg;

    public JgraphTRoutingService(List<CountryInfo> countries) {
        this.availableCountries = countries.stream().map(CountryInfo::getName).collect(Collectors.toList());
        this.graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        this.availableCountries.forEach(graph::addVertex);
        countries.forEach(country -> {
            var name = country.getName();
            country.getBorders().forEach(boarder -> graph.addEdge(name, boarder));
        });
        dijkstraAlg = new DijkstraShortestPath<>(graph);

    }

    public List<String> find(String from, String to) {
        Validations.isTrue(availableCountries.contains(from), "Country " + from + " is not valid code");
        Validations.isTrue(availableCountries.contains(to), "Country " + to + " is not valid code");
        var result = dijkstraAlg.getPath(from, to);
        return Optional.ofNullable(result).map(GraphPath::getVertexList).orElse(null);
    }

}

