package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Meteor;
import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Repository.MeteorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/meteor-add")
    public String AddMeteor(@Valid Meteor meteor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "meteor/meteor-add";
        }
        meteorRepository.save(meteor);
        return "redirect:/meteor/";
    }
    @GetMapping("/meteor-add/")
    public String AddView(Meteor meteor){
        return "meteor/meteor-add";
    }

//    @GetMapping("/filter/")
//    public String filter(
//            @RequestParam(name="name_meteor") String name_meteor,
//            Model model){
//        List<Meteor> meteorList = meteorRepository.findByName_meteor(name_meteor);
//        model.addAttribute("meteor_list", meteorList);
//        return"meteor/index";
//    }
//    @GetMapping("/filtercontains/")
//    public String filterContains(
//            @RequestParam(name="name_meteor") String name_meteor,
//            Model model){
//        List<Meteor> meteorList = meteorRepository.findMeteorByName_meteorContains(name_meteor);
//        model.addAttribute("meteor_list", meteorList);
//        return"meteor/index";
//    }

    @GetMapping("/detail/{id}")
    public String detailMeteor(
            @PathVariable Long id,
            Model model
    ){
        Meteor meteor_obj = meteorRepository.findById(id).orElseThrow();
        model.addAttribute("one_meteor", meteor_obj);
        return "meteor/info";
    }
    @PostMapping ("/detail/{id}/del")
    public String  delMeteor(@PathVariable Long id)
    {
        Meteor meteor_obj = meteorRepository.findById(id).orElseThrow();
        meteorRepository.delete(meteor_obj);
        return "redirect:/meteor/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String  updateView(@PathVariable Long id,Meteor meteor,Model model)
    {
        meteor = meteorRepository.findById(id).orElseThrow();
        model.addAttribute("meteor",meteor);
        return "meteor/meteor-update";
    }
    @PostMapping ("/detail/{id}/upd")
    public String update(@Valid Meteor meteor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "meteor/meteor-update";
        }

        meteorRepository.save(meteor);
        return "redirect:/meteor/detail/"+meteor.getUID();
    }

}
