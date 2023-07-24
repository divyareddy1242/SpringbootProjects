package dtn.fd.com.submission.repositories;

import dtn.fd.com.submission.models.LeadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadDetailsRepository extends JpaRepository<LeadDetails,Long> {
}
