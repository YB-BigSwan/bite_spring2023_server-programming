package com.example.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam(name="firstname", required=false, defaultValue="World")String firstname, @RequestParam(name="location") String location) {
        return "Welcome to " + location +  " " + firstname + "!";
    }
}
