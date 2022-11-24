package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Star;
import com.example.pr_spring_1.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/star")
public class StarController {
    @Autowired
    StarRepository starRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<Star> starIterable = starRepository.findAll();
        model.addAttribute("star_list", starIterable);
        return "star/index";}
    @PostMapping("/star-add/")
    public String AddStar(
            @RequestParam(name="name") String name,
            @RequestParam(name="class_star") String class_star,
            @RequestParam(name="lumen") int lumen){
        Star new_star = new Star(name, class_star, lumen);
        starRepository.save(new_star);
        return "redirect:/star/";}
    @GetMapping("/star-add/")
    public String AddView(){
        return "star/star-add";}
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
    public String  updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("object",starRepository.findById(id).orElseThrow());
        return "star/star-update";
    }
    @PostMapping ("/detail/{id}/upd")
    public String  update(@PathVariable Long id,@RequestParam String name, @RequestParam String class_star, Integer lumen)
    {
        Star star = starRepository.findById(id).orElseThrow();

        star.setName(name);
        star.setClass_star(class_star);
        star.setLumen(lumen);

        starRepository.save(star);
        return "redirect:/star/detail/"+star.getUID();
    }
}
