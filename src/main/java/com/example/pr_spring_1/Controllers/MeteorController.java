package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Meteor;
import com.example.pr_spring_1.Repository.MeteorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/meteor")
public class MeteorController {
    @Autowired
    MeteorRepository meteorRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<Meteor> meteorIterable = meteorRepository.findAll();
        model.addAttribute("meteor_list", meteorIterable);
        return "meteor/index";}
    @PostMapping("/meteor-add/")
    public String AddMeteor(@RequestParam(name="name_meteor") String name_meteor,
              @RequestParam(name="class_meteor") String class_meteor,
              @RequestParam(name="location_meteor") String location_meteor,
              @RequestParam(name="weight") String weight,
              @RequestParam(name="color_meteor") String color_meteor)
    {Meteor new_meteor = new Meteor(name_meteor, class_meteor, location_meteor,weight,color_meteor);
        meteorRepository.save(new_meteor);
        return "meteor/meteor-add";}
    @GetMapping("/meteor-add/")
    public String AddView(){
        return "meteor/meteor-add";
    }
}
