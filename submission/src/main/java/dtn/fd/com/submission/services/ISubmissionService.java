package dtn.fd.com.submission.services;


import dtn.fd.com.submission.dto.requests.SubmissionRequest;
import dtn.fd.com.submission.models.Submission;

import java.util.List;

public interface ISubmissionService {

     List<Submission> getAllSubmission(String lead);
     List<Submission> searchSubmissionByVendorName(String lead);
     Submission getSubmissionBySubmissionId(Long id);

     Submission createSubmission(SubmissionRequest submissionRequest);
     Submission updateSubmissionBySubmissionId(Long submissionId, SubmissionRequest submissionRequest);
     Long deleteSubmissionBySubmissionId(Long submissionId);

     void deleteAll();
}
