package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.Complaint;

import java.util.List;

public interface ComplaintService {
    public boolean isUserLoggedIn();
    public String getUsername();
    public Complaint getOne(Long id);
    public void save(Complaint complaint);
    public void remove(Long id);
    public void update();
    public List<Complaint> getAllByArchiveIsTrue();
    public List<Complaint> getAllByArchiveIsFalse();
}
