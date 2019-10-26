package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.models.User;
import net.usermd.jrkn87.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterAndLoginController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }
    @PostMapping("/register")
    public String postRegister(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "registerForm";
        else {
            userService.addDefaultUserRole(user);
            return "registerSuccess";
        }
    }
}
