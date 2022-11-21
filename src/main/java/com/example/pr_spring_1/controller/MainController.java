package com.example.pr_spring_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    float num_post;
    float num_get;

    @PostMapping("/Post")
    public String calc_Post(@RequestParam(required = false)  float num1_post, float num2_post, String action, Model model) {
        switch (action) {
            case "plus":
                num_post = num1_post + num2_post;
                break;
            case "minus":
                num_post = num1_post - num2_post;
                break;
            case "multiply":
                num_post = num1_post * num2_post;
                break;
            case "divide":
                num_post = num1_post / num2_post;
                break;
        }
        model.addAttribute("num1_post", num1_post);
        model.addAttribute("num2_post", num2_post);
        model.addAttribute("num_answer_post", num_post);
        return "post_page";
    }

    @GetMapping("/Post")
    public String post() {
        return "post_page";
    }

    @GetMapping("/Get")
    public String numGet(@RequestParam(required = false) float num1_get, float num2_get, String action, Model model) {
        switch(action){
            case "plus":
                num_get = num1_get + num2_get;
                break;
            case "minus":
                num_get = num1_get - num2_get;
                break;
            case "multiply":
                num_get = num1_get * num2_get;
                break;
            case "divide":
                num_get = num1_get / num2_get;
                break;
        }
        model.addAttribute("num1_get", num1_get);
        model.addAttribute("num2_get", num2_get);
        model.addAttribute("num_answer_get", num_get);
        return "get_page";
    }

}
