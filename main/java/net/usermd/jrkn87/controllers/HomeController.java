package net.usermd.jrkn87.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/jrk")
    public String home() {
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model) {
        boolean clicked = true;
        model.addAttribute("clicked", clicked);
        return "complaints";
    }
}
