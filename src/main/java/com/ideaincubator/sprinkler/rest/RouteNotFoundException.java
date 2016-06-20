package com.ideaincubator.sprinkler.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException(String storyId) {
        super(String.format("Story with id %s not found", storyId));
    }
}
