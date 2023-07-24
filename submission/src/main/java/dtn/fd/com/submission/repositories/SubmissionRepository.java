package dtn.fd.com.submission.repositories;


import dtn.fd.com.submission.models.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {

    List<Submission> findByVendorName(String vendorName);
}
