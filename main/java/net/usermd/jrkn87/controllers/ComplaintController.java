package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.models.Consumer;
import net.usermd.jrkn87.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ComplaintController {
    @Autowired
    ConsumerRepository consumerRepository;

    @GetMapping("/complaints")
    public String getComplaints(Model model) {
        List<Consumer> consumers = consumerRepository.findAll();
        model.addAttribute("consumers", consumers);
        model.addAttribute("currentDate",LocalDate.now());
        return "complaints";
    }
    @GetMapping("/add-complaint")
    public String complaint(Model model) {
        model.addAttribute("consumer", new Consumer());
        return "add-complaint";
    }
    @PostMapping("/add-complaint")
    public String addComplaint(@ModelAttribute @Valid Consumer consumer, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add-complaint";
        else
            consumerRepository.save(consumer);
        return "redirect:/complaints";
    }
}
