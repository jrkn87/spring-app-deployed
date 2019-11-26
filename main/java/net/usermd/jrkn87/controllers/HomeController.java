package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private ComplaintService complaintService;
    @Autowired
    public void setComplaintService(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("issLogged", complaintService.isUserLoggedIn());
        model.addAttribute("username", complaintService.getUsername());
        return "home_";
    }
}
