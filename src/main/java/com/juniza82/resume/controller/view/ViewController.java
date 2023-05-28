package com.juniza82.resume.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("test", "개인 공간 테스트");
        return "index";
    }

    @GetMapping("/viewToIndex")
    public String viewToIndex() {
        return "index";
    }

    @GetMapping("/viewToResume")
    public String viewToResume() {
        return "resume";
    }

    @GetMapping("/viewToContent")
    public String viewToContent() {
        return "content";
    }

    @GetMapping("/viewToProjects")
    public String viewToProjects() {
        return "projects";
    }
}
