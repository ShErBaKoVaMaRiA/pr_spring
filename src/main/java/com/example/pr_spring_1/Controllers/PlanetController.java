package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/planet")
public class PlanetController {
    @Autowired
    PlanetRepository planetRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<Planet> planetIterable = planetRepository.findAll();
        model.addAttribute("planet_list", planetIterable);
        return "planet/index";}
    @PostMapping("/planet-add/")
    public String AddPlanet(
            @RequestParam(name="name_planet") String name_planet,
            @RequestParam(name="weight_planet") float weight_planet,
            @RequestParam(name="sputnik_planet") String sputnik_planet,
            @RequestParam(name="rotation_period") String rotation_period,
            @RequestParam(name="temperature") float temperature){
        Planet new_planet = new Planet(name_planet, weight_planet, sputnik_planet,rotation_period,temperature);
        planetRepository.save(new_planet);
        return "planet/planet-add";}
    @GetMapping("/planet-add/")
    public String AddView(){
        return "planet/planet-add";
    }
}