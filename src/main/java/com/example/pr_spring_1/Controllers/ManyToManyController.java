package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Constellations;
import com.example.pr_spring_1.Models.Meteor;
import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Models.Stars;
import com.example.pr_spring_1.Repository.ConstellationsRepository;
import com.example.pr_spring_1.Repository.MeteorRepository;
import com.example.pr_spring_1.Repository.PlanetRepository;
import com.example.pr_spring_1.Repository.StarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ManyToManyController {
    @Autowired
    public PlanetRepository planetRepository;
    @Autowired
    public MeteorRepository meteorRepository;


    @GetMapping("/many/add/")
    private String Main(Model model){
        Iterable<Planet> planet = planetRepository.findAll();
        model.addAttribute("planet", planet);
        Iterable<Meteor> meteor = meteorRepository.findAll();
        model.addAttribute("meteor", meteor);
        return "many";
    }

    @PostMapping("/many/add/")
    public String blogPostAdd(@RequestParam String meteor,@RequestParam String planet,  Model model)
    {
        Planet planet2 = planetRepository.findByName(planet);
        Meteor meteor2 = meteorRepository.findByName(meteor);

        meteor2.getPlanet().add(planet2);
        meteorRepository.save(meteor2);
        return "many";
    }
}
