package net.usermd.jrkn87.repositories;

import net.usermd.jrkn87.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findAllByIsArchiveIsTrue();
    List<Complaint> findAllByIsArchiveIsFalse();
}
