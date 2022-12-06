package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Constellations;
import com.example.pr_spring_1.Models.Meteors;
import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Repository.MeteorsRepository;
import com.example.pr_spring_1.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MeteorsController {

    @Autowired
    private MeteorsRepository meteorsRepository;
    @Autowired
    private PlanetRepository planetRepository;

    @GetMapping("/meteors/add")
    public String Main(Model model){
        Iterable<Planet> planet = planetRepository.findAll();
        ArrayList<Planet> planetArrayList = new ArrayList<>();
        for (Planet pass: planet) {
            if (pass.getMeteors() == null) {
                planetArrayList.add(pass);
            }
        }
        model.addAttribute("planetname", planet);
        return "meteor_planet";
    }

//    @GetMapping("/meteors/add")
//    public String Mains(Model model) {
//        Iterable<Planet> planet = planetRepository.findAll();
//        model.addAttribute("planetname", planet);
//        return "meteor_planet";
//    }


    @PostMapping("/meteors/add")
    public String blogPostAdd(@RequestParam String name,  @RequestParam String planetname, Model model)
    {
        Planet planet = planetRepository.findByName(planetname);
        Meteors meteors = new Meteors(name,planet);
        meteorsRepository.save(meteors);
        return "meteor_planet";
    }
}
