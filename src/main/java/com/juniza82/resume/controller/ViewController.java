package com.juniza82.resume.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ViewController {

    @GetMapping("/index")
    public String Hello() {
        System.out.println("index!!");
        return "index";
    }

    @GetMapping("/resume")
    public String Resume() {
        System.out.println("resume!!");
        return "resume";
    }
}
