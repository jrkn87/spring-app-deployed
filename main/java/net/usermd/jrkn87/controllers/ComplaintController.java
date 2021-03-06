package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.services.ComplaintService;
import net.usermd.jrkn87.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @GetMapping("/complaints")
    public String getComplaints(Model model) {
        model.addAttribute("issLogged", complaintService.isUserLoggedIn());
        model.addAttribute("username", complaintService.getUsername());
        List<Complaint> complaints = complaintService.getAllByArchiveIsFalse();
        model.addAttribute("complaints", complaints);
        complaintService.update();
        return "complaints";
    }
    @GetMapping("/archive")
    public String getComplaintsArchive(Model model) {
        model.addAttribute("issLogged", complaintService.isUserLoggedIn());
        model.addAttribute("username", complaintService.getUsername());
        List<Complaint> complaints = complaintService.getAllByArchiveIsTrue();
        model.addAttribute("complaints", complaints);
        return "complaints-archive";
    }
    @GetMapping("/add-complaint")
    public String complaint( Model model) {
        model.addAttribute("issLogged", complaintService.isUserLoggedIn());
        model.addAttribute("username", complaintService.getUsername());
        model.addAttribute("complaint", new Complaint());
        return "add-complaint";
    }
    @GetMapping("/details")
    public String details(@RequestParam("id") Long id,Model model) {
        model.addAttribute("issLogged", complaintService.isUserLoggedIn());
        model.addAttribute("username", complaintService.getUsername());
        Complaint complaint = complaintService.getOne(id);
        model.addAttribute("complaint", complaint);
        model.addAttribute("allStatus", Status.values());
        return "details-complaint";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("id") Long id) {
        complaintService.remove(id);
        return "redirect:/complaints";
    }
    @PostMapping("/add-complaint")
    public String addComplaint(@Valid @ModelAttribute Complaint complaint, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            return "add-complaint";
        }
        else
            complaintService.save(complaint);
        return "redirect:/complaints";
    }
}
