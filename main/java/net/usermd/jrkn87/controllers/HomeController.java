package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.services.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("issLogged", ComplaintService.isUserLoggedIn());
        model.addAttribute("username", ComplaintService.getUsername());
        return "home";
    }
}
