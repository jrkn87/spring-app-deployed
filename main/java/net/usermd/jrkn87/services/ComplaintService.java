package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    public List<Complaint> complaintList() {
        return complaintRepository.findAll()
                .stream()
                .filter(c -> !c.isArchive())
                .collect(Collectors.toList());
    }
    public List<Complaint> complaintListArchive() {
        return complaintRepository.findAll()
                .stream()
                .filter(c -> c.isArchive())
                .collect(Collectors.toList());
    }

    public int getDurationTimeOnDays(Complaint complaint) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = complaint.getStartDate();
        int daysElapsed = (int) ChronoUnit.DAYS.between(startDate, endDate);
        return daysElapsed;
    }
    public int getDurationTimeOnDaysOnService(Complaint complaint) {
        int daysElapsed = 0;
        LocalDate before = complaint.getPushServiceDate();
        LocalDate now = LocalDate.now();
        LocalDate after = complaint.getPullServiceDate();
        if (before != null) {
        	if (after == null)
                daysElapsed = (int) ChronoUnit.DAYS.between(before, now);
        	else 
        		daysElapsed = (int) ChronoUnit.DAYS.between(before, after);
        }
        return daysElapsed;
    }

    static public boolean isUserLoggedIn(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean b = principal instanceof UserDetails;
        return b;
    }
    static public String getUsername(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return username;
    }

    public Complaint getOne(Long id) {
        return complaintRepository.getOne(id);
    }
    public void save(Complaint complaint) {
            complaintRepository.save(complaint);
    }
    public void remove(Long id) {
        complaintRepository.deleteById(id);
    }
	public void update() {
		complaintRepository.flush();
	}
}
