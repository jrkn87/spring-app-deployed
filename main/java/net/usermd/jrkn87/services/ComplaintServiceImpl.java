package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.Complaint;
import net.usermd.jrkn87.models.User;
import net.usermd.jrkn87.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    UserService userService;

    @Autowired
    ComplaintRepository complaintRepository;

    public boolean isUserLoggedIn(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean b = principal instanceof UserDetails;
        return b;
    }
    public String getUsername(){
       String username;
       Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
       User user = userService.findByUsername(loggedInUser.getName());
       if (user != null)
         username = user.getFirstName();
       else
         username = "Default_Name";
       return username;
     }
    @Override
    public Complaint getOne(Long id) {
            return complaintRepository.getOne(id);
        }
    @Override
    public void save(Complaint complaint) {
            complaintRepository.save(complaint);
        }
    @Override
    public void remove(Long id) {
            complaintRepository.deleteById(id);
        }
    @Override
    public void update() {
            complaintRepository.flush();
        }
    @Override
    public List<Complaint> getAllByArchiveIsTrue() {
        return complaintRepository.findAllByIsArchiveIsTrue();
    }
    @Override
    public List<Complaint> getAllByArchiveIsFalse() {
        return complaintRepository.findAllByIsArchiveIsFalse();
    }
}