package com.example.pr_spring_1.Controllers;

import com.example.pr_spring_1.Models.Role;
import com.example.pr_spring_1.Models.User;
import com.example.pr_spring_1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/")
    public String userView(Model model) {
        model.addAttribute("user_list", userRepository.findAll());
        return "user/index";
    }
    @GetMapping("/{id}")
    public String detailView(@PathVariable Long id, Model model) {
        model.addAttribute("user_object", userRepository.findById(id).orElseThrow());

        return "user/info";
    }
    @GetMapping("/{id}/update")
    public String updView(@PathVariable Long id, Model model) {
        model.addAttribute("user_object", userRepository.findById(id).orElseThrow());
        model.addAttribute("roles", Role.values());
        return "user/update";
    }
    @PostMapping("/{id}/update")
    public String update_user(
            @RequestParam String username,
            @RequestParam(name = "roles[]", required = false) String[] roles,
            @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(username);
        user.getRoles().clear();
        if (roles != null) {
            for (String role :
                    roles) {
                user.getRoles().add(Role.valueOf(role));
            }
        }
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return "redirect:/admin/";
    }
}