package dtn.fd.com.submission.dao.impl;

import dtn.fd.com.submission.dao.ISubmissionDao;
import dtn.fd.com.submission.models.Submission;
import dtn.fd.com.submission.repositories.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionDaoImpl implements ISubmissionDao {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public List<Submission> getAllSubmission() {
        return submissionRepository.findAll();
    }

    @Override
    public List<Submission> searchSubmissionByVendorName(String vendorName) {
        return submissionRepository.findByVendorName(vendorName);
    }

    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Submission getSubmissionBySubmissionId(Long submissionId) {
        return submissionRepository.findById(submissionId).orElseThrow();
    }

    @Override
    public Submission updateSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Long deleteSubmissionBySubmissionId(Long submissionId) {
        submissionRepository.deleteById(submissionId);
        return submissionId;
    }
}
