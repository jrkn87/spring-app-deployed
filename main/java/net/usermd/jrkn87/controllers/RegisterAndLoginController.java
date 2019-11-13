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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class RegisterAndLoginController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null)
            model.addAttribute("error", "Zła nazwa użytkownika lub/i hasło!");
        return "login-form";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        Set<String> allLogin = userService.getAll()
                .stream()
                .map(u -> u.getNick())
                .collect(Collectors.toSet());
        if (bindingResult.hasErrors())
            return "register-form";
        else if (allLogin.contains(user.getNick())) {
            model.addAttribute("err_user", "Taki użytkownik istnieje już w bazie!!");
            return "register-form";
        }

        else {
            userService.addDefaultUserRole(user);
            return "registerSuccess";
        }
    }
}
