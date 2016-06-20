package com.ideaincubator.sprinkler.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloWorld {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String ping() {
        return "{'guest':'hello'}";
    }
    
    public HelloWorld(){
    	
    }
}
