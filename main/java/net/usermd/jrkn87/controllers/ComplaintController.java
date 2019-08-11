package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.repositories.ComplaintRepository;
import net.usermd.jrkn87.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ComplaintController {
    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplaintService complaintService;

    @GetMapping("/complaints")
    public String getComplaints(Model model) {
        List<Complaint> complaints = complaintRepository.findAll();
        complaints.stream().forEach(e -> e.setDurationTimeOnDays(complaintService.getDurationTimeOnDays(e)));
        model.addAttribute("complaints", complaints);
        model.addAttribute("chk", null);
        return "complaints";
    }
    @GetMapping("/add-complaint")
    public String complaint( Model model) {
        model.addAttribute("complaint", new Complaint());
        return "add-complaint";
    }
    @GetMapping("/details")
    public String details(@RequestParam("id") Long id,Model model) {
        Complaint complaint = complaintRepository.getOne(id);
        model.addAttribute("complaint", complaint);
        return "details-complaint";
    }
    @PostMapping("/add-complaint")
    public String addComplaint(@ModelAttribute @Valid Complaint complaint, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add-complaint";
        else
            complaintRepository.save(complaint);
        return "redirect:/complaints";
    }
}
