package com.example.RestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private RestOperations restTemplate;

    @GetMapping("/users")
    public List<User> getUsers(){
        ParameterizedTypeReference<List<User>> response = new ParameterizedTypeReference<List<User>>() {
        };
        ResponseEntity<List<User>> responseEntity= restTemplate.exchange("http://localhost:8080/users",
                HttpMethod.GET,null,response);
        List<User> users = responseEntity.getBody();

return  users;

    }

}
