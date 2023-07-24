package dtn.fd.com.submission.services.impl;

import dtn.fd.com.submission.dao.ISubmissionDao;
import dtn.fd.com.submission.dto.requests.SubmissionRequest;
import dtn.fd.com.submission.models.Submission;
import dtn.fd.com.submission.services.ISubmissionService;
import dtn.fd.com.submission.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements ISubmissionService {

    @Autowired
    private ISubmissionDao submissionDao;

    @Override
    public List<Submission> getAllSubmission(String vendorName) {
        if(vendorName==null)
            return submissionDao.getAllSubmission();
        else
            return searchSubmissionByVendorName(vendorName);
    }

    @Override
    public Submission getSubmissionBySubmissionId(Long submissionId) {
        return submissionDao.getSubmissionBySubmissionId(submissionId);
    }

    @Override
    public List<Submission> searchSubmissionByVendorName(String vendorName) {
        return submissionDao.searchSubmissionByVendorName(vendorName);
    }

    @Override
    public Submission createSubmission(SubmissionRequest submissionRequest) {
        Submission submission = ObjectMapperUtils.map(submissionRequest, Submission.class);
        return submissionDao.createSubmission(submission);
    }

    @Override
    public Submission updateSubmissionBySubmissionId(Long submissionId, SubmissionRequest submissionRequest) {
        Submission submission = submissionDao.getSubmissionBySubmissionId(submissionId);
        submission.setConsultantId(submissionRequest.getConsultantId());
        submission.setSubmissionDate(submissionRequest.getSubmissionDate());
        submission.setVendorCompany(submissionRequest.getVendorCompany());
        submission.setVendorName(submissionRequest.getVendorName());
        submission.setVendorEmailAddress(submissionRequest.getVendorEmailAddress());
        submission.setVendorPhoneNumber(submissionRequest.getVendorPhoneNumber());
        submission.setImplementationPartner(submissionRequest.getImplementationPartner());
        submission.setClientName(submissionRequest.getClientName());
        submission.setPayRate(submissionRequest.getPayRate());
        submission.setSubmissionStatus(submissionRequest.getSubmissionStatus());
        submission.setSubmissionType(submissionRequest.getSubmissionType());
        submission.setCity(submissionRequest.getCity());
        submission.setState(submissionRequest.getState());
        submission.setZip(submissionRequest.getZip());
        return submissionDao.updateSubmission(submission);
    }

    @Override
    public Long deleteSubmissionBySubmissionId(Long submissionId) {
        return submissionDao.deleteSubmissionBySubmissionId(submissionId);
    }


    @Override
    public void deleteAll() {

    }
}
