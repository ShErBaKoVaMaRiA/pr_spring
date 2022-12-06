package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Meteor;
import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Models.Star;
import com.example.pr_spring_1.Repository.MeteorRepository;
import com.example.pr_spring_1.Repository.PlanetRepository;
import com.example.pr_spring_1.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.PlaceholdersResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/planet")
@PreAuthorize("hasAnyAuthority('USER')")
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<Planet> planetIterable = planetRepository.findAll();
        model.addAttribute("planet_list", planetIterable);
        return "planet/index";}

    @PostMapping("/planet-add")
    public String AddPlanet(@Valid Planet planet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "planet/planet-add";
        }
        planetRepository.save(planet);
        return "redirect:/planet/";
    }
    @GetMapping("/planet-add/")
    public String AddView(Planet planet){
        return "planet/planet-add";
    }


    @GetMapping("/detail/{id}")
    public String detailPlanet(
            @PathVariable Long id,
            Model model
    ){
        Planet planet_obj = planetRepository.findById(id).orElseThrow();
        model.addAttribute("one_planet", planet_obj);
        return "planet/info";
    }
    @PostMapping ("/detail/{id}/del")
    public String  delPlanet(@PathVariable Long id)
    {
        Planet planet_obj = planetRepository.findById(id).orElseThrow();
        planetRepository.delete(planet_obj);
        return "redirect:/planet/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String  updateView(@PathVariable Long id,Planet planet,Model model)
    {
        planet = planetRepository.findById(id).orElseThrow();
        model.addAttribute("planet",planet);
        return "planet/planet-update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String update(@Valid Planet planet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "planet/planet-update";
        }

        planetRepository.save(planet);
        return "redirect:/planet/detail/"+planet.getUID();
    }
}