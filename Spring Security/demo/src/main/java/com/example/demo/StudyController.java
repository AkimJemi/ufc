package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudyController {
    @RequestMapping("study")
    public String init(){
        System.out.println("ddd");
        System.out.println("sss");
        return "studyList";
    }
}



