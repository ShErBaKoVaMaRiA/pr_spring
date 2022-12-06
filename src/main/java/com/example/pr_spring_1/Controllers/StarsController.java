package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Constellations;
import com.example.pr_spring_1.Models.Stars;
import com.example.pr_spring_1.Repository.ConstellationsRepository;
import com.example.pr_spring_1.Repository.StarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Console;

@Controller
public class StarsController {
    @Autowired
    public ConstellationsRepository constellationsRepository;
    @Autowired
    public StarsRepository starsRepository;

    @GetMapping("/star_constell")
    public String index(Model model) {
        Iterable<Constellations> constellations = constellationsRepository.findAll();
        Iterable<Stars> stars = starsRepository.findAll();
        model.addAttribute("stars", stars);
        model.addAttribute("constellations", constellations);
        return "stars_all";
    }

    @GetMapping("/star_constell/add")
    public String Main(Model model) {
        Iterable<Constellations> constellations = constellationsRepository.findAll();
        model.addAttribute("constellations", constellations);
        return "star_constell";
    }

    @PostMapping("/star_constell/add")
    public String starsAdd(@RequestParam(name="name") String name, @RequestParam(name="constellations") String Name_Con, Model model) {

        Constellations constellationsfind = constellationsRepository.findByName(Name_Con);
        Stars stars = new Stars(name, constellationsfind);
        starsRepository.save(stars);
        return "redirect:/star_constell";
    }
}