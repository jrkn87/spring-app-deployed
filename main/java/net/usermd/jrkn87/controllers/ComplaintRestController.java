package net.usermd.jrkn87.controllers;

import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController("/api/complaints")
public class ComplaintRestController {
    @Autowired
    ComplaintService complaintService;

    @GetMapping
    public Collection<Complaint> getAllComplaints() {
        return complaintService.getAllByArchiveIsFalse();
    }
}
