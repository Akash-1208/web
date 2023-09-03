package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;

import com.example.web.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class Employeecontroller {

	@Autowired
	WebClient createClient;
	
    //Get all posts
    @GetMapping("/v1/posts")
    public Flux<Employee> findAll(){
        return createClient.get().uri("/posts")
                .retrieve()
                .bodyToFlux(Employee.class);
    }

    //Get record by id
    @GetMapping("/v1/posts/{id}")
    public Mono<Employee> findById(@PathVariable String id){
        return createClient.get()
        .uri("/posts/"+id)
        .retrieve()
        .bodyToMono(Employee.class);
    }

    //Deleting a record by id
    @DeleteMapping("v1/post/{id}")
    public Mono<Employee> deletePost(@PathVariable String id){
        return createClient.delete()
        .uri("/posts/"+id)
        .retrieve()
        .bodyToMono(Employee.class);
    }

    //Posting data
    @PostMapping(path="v1/post",consumes=MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> createpost(@RequestBody Employee employee){
        return createClient.post()
        .uri("/posts")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(BodyInserters.fromValue(employee))
        .retrieve()
        .bodyToMono(Employee.class);
    }
	
}