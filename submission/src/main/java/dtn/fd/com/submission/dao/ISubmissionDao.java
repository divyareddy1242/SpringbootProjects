package dtn.fd.com.submission.dao;

import dtn.fd.com.submission.models.Submission;

import java.util.List;

public interface ISubmissionDao {

    List<Submission> getAllSubmission();

    Submission getSubmissionBySubmissionId(Long submissionId);

    List<Submission> searchSubmissionByVendorName(String vendorName);
    Submission createSubmission(Submission submission);

    Submission updateSubmission(Submission submission);

    Long deleteSubmissionBySubmissionId(Long submissionId);

}
