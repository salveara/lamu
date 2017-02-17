package com.lamu.lamuApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    
    @RequestMapping("/client")
    public String person(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "client";
    }
    
    @RequestMapping("/song")
    public String song(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name);
        return "song";
    }
    
    @RequestMapping("/reproductionlist")
    public String reproductionList(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name);
        return "client";
    }

}
