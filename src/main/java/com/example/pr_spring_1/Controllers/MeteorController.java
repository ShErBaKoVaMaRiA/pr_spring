package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Meteor;
import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Repository.MeteorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/meteor")
public class MeteorController {
    @Autowired
    MeteorRepository meteorRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Meteor> meteorIterable = meteorRepository.findAll();
        model.addAttribute("meteor_list", meteorIterable);
        return "meteor/index";
    }

    @PostMapping("/meteor-add/")
    public String AddMeteor(@RequestParam(name = "name_meteor") String name_meteor,
                            @RequestParam(name = "class_meteor") String class_meteor,
                            @RequestParam(name = "location_meteor") String location_meteor,
                            @RequestParam(name = "weight") String weight,
                            @RequestParam(name = "color_meteor") String color_meteor) {
        Meteor new_meteor = new Meteor(name_meteor, class_meteor, location_meteor, weight, color_meteor);
        meteorRepository.save(new_meteor);
        return "meteor/meteor-add";
    }

    @GetMapping("/meteor-add/")
    public String AddView() {
        return "meteor/meteor-add";
    }


    @GetMapping("/detail/{id}")
    public String detailMeteor(
            @PathVariable Long id,
            Model model
    ) {
        Meteor meteor_obj = meteorRepository.findById(id).orElseThrow();
        model.addAttribute("one_meteor", meteor_obj);
        return "meteor/info";
    }

    @PostMapping("/detail/{id}/del")
    public String delMeteor(@PathVariable Long id) {
        Meteor meteor_obj = meteorRepository.findById(id).orElseThrow();
        meteorRepository.delete(meteor_obj);
        return "redirect:/meteor/";
    }

    @GetMapping("/detail/{id}/upd")
    public String updateView(@PathVariable Long id, Model model) {
        model.addAttribute("object", meteorRepository.findById(id).orElseThrow());
        return "meteor/meteor-update";
    }

    @PostMapping("/detail/{id}/upd")
    public String update(@PathVariable Long id, @RequestParam String name, @RequestParam String class_meteor,
                         @RequestParam String location_meteor, @RequestParam String weight,
                         @RequestParam String color_meteor) {
        Meteor meteor = meteorRepository.findById(id).orElseThrow();

        meteor.setName(name);
        meteor.setClass_meteor(class_meteor);
        meteor.setLocation_meteor(location_meteor);
        meteor.setWeight(weight);
        meteor.setColor_meteor(color_meteor);

        meteorRepository.save(meteor);
        return "redirect:/meteor/detail/" + meteor.getUID();
    }
}