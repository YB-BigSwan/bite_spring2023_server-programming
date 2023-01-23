package com.example.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Index {
    @RequestMapping("/index")
    public String hello() {
        return "This is the main page of the website";
    }
}
