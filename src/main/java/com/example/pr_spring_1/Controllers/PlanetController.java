package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Planet;
import com.example.pr_spring_1.Models.Star;
import com.example.pr_spring_1.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.PlaceholdersResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
//    @PostMapping("/planet-add/")
//    public String AddPlanet(
//            @RequestParam(name="name_planet") String name_planet,
//            @RequestParam(name="weight_planet") float weight_planet,
//            @RequestParam(name="sputnik_planet") String sputnik_planet,
//            @RequestParam(name="rotation_period") String rotation_period,
//            @RequestParam(name="temperature") float temperature){
//        Planet new_planet = new Planet(name_planet, weight_planet, sputnik_planet,rotation_period,temperature);
//        planetRepository.save(new_planet);
//        return "planet/planet-add";}
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



//    @GetMapping("/filter/")
//    public String filter(
//            @RequestParam(name="name") String name,
//            Model model){
//        List<Planet> planetList = planetRepository.findByName_planet(name);
//        model.addAttribute("planet_list", planetList);
//        return"planet/index";
//    }
//    @GetMapping("/filtercontains/")
//    public String filterContains(
//            @RequestParam(name="name") String name,
//            Model model){
//        List<Planet> planetList = planetRepository.findByName_planetContains(name);
//        model.addAttribute("planet_list", planetList);
//        return"planet/index";
//    }

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