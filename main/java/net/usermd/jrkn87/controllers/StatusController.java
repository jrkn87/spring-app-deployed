package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.repositories.ComplaintRepository;
import net.usermd.jrkn87.services.ComplaintService;
import net.usermd.jrkn87.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatusController {
    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    ComplaintService complaintService;



    @PostMapping("/test")
    public String pushToService(Complaint complaint) {
        Complaint updateComplaint = complaintService.getOne(complaint.getId());
        updateComplaint.setStatus(complaint.getStatus());
        Status status = complaint.getStatus();
        if (status.equals(Status.SHIPPING))
            updateComplaint.setPushServiceDate();
        if (status.equals(Status.PICK_UP))
            updateComplaint.setPullServiceDate();
        if (status.equals(Status.COMPLETED))
            updateComplaint.setArchive(true);

        complaintRepository.flush();
        return "redirect:/details?id="+complaint.getId();
    }
}
