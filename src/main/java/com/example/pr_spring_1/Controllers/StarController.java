package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Constellations;
import com.example.pr_spring_1.Models.Star;
import com.example.pr_spring_1.Repository.ConstellationsRepository;
import com.example.pr_spring_1.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/star")
@PreAuthorize("hasAnyAuthority('USER')")
public class StarController {
    @Autowired
    public StarRepository starRepository;


    @GetMapping("/")
    public String index(Model model){
        Iterable<Star> starIterable = starRepository.findAll();
        model.addAttribute("star_list", starIterable);
        return "star/index";}

    @PostMapping("/star-add")
    public String AddStar(@Valid Star star, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "star/star-add";
        }
        starRepository.save(star);
        return "redirect:/star/";
    }
    @GetMapping ("/star-add")
    public String AddView(Star star){
        return "star/star-add";
    }
    @GetMapping("/filter/")
    public String filter(
            @RequestParam(name="name") String name,
            Model model){
        List<Star> starList = starRepository.findByName(name);
        model.addAttribute("star_list", starList);
        return"star/index";
    }
    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="name") String name,
            Model model){
        List<Star> starList = starRepository.findByNameContains(name);
        model.addAttribute("star_list", starList);
        return"star/index";
    }

    @GetMapping("/detail/{id}")
    public String detailStar(
            @PathVariable Long id,
            Model model
    ){
        Star star_obj = starRepository.findById(id).orElseThrow();
        model.addAttribute("one_star", star_obj);
        return "star/info";
    }
    @PostMapping ("/detail/{id}/del")
    public String  delStar(@PathVariable Long id)
    {
        Star star_obj = starRepository.findById(id).orElseThrow();
        starRepository.delete(star_obj);
        //==
        //starRepository.deleteById(id);
        return "redirect:/star/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String  updateView(@PathVariable Long id, Star star, Model model)
    {
        star = starRepository.findById(id).orElseThrow();
        model.addAttribute("star",star);
        return "star/star-update";
    }
    @PostMapping ("/detail/{id}/upd")
    public String update(@Valid Star star, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "star/star-update";
        }

        starRepository.save(star);
        return "redirect:/star/detail/"+star.getUID();
    }
}
