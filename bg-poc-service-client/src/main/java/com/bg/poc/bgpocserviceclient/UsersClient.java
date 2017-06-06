package com.bg.poc.bgpocserviceclient;

import com.bg.poc.bgpocserviceclient.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UsersClient {

    private static final String ENDPOINT = "http://bg-poc-service/users";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/users")
    public List<User> listUsers() {
        return Optional.of(restTemplate.exchange(ENDPOINT, HttpMethod.GET, null, new ParameterizedTypeReference<Resources<User>>() {
        }))
                .orElse(ResponseEntity.ok(new Resources<User>(Collections.EMPTY_LIST))).getBody().getContent().stream().collect(Collectors.toList());
    }
}
