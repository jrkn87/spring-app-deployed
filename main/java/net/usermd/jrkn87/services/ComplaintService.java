package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.Complaint;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ComplaintService {

    public int getDurationTimeOnDays(Complaint complaint) {
        LocalDate localDate = LocalDate.now();
        LocalDate startDate = complaint.getStartDate();
        Period between = Period.between(startDate, localDate);
        Integer daysElapsed = between.getDays ();
        return daysElapsed;
    }
}
