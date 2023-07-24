package dtn.fd.com.submission.services.impl;

import dtn.fd.com.submission.dao.ILeadDetailsDao;
import dtn.fd.com.submission.dto.requests.LeadDetailsRequest;
import dtn.fd.com.submission.models.LeadDetails;
import dtn.fd.com.submission.services.ILeadDetailsService;
import dtn.fd.com.submission.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadDetailServiceImpl implements ILeadDetailsService {

    @Autowired
    private ILeadDetailsDao leadDetailsDao;

    @Override
    public List<LeadDetails> getAllLeadDetails() {
        return leadDetailsDao.getAllLeadDetails();
    }

    @Override
    public LeadDetails createLeadDetails(LeadDetailsRequest leadDetailsRequest) {
        LeadDetails leadDetails = ObjectMapperUtils.map(leadDetailsRequest, LeadDetails.class);
        return leadDetailsDao.createLeadDetails(leadDetails);
    }

    @Override
    public LeadDetails getLeadDetails(Long leadId) {
        return leadDetailsDao.getLeadDetails(leadId);
    }

    @Override
    public LeadDetails updateLeadDetails(LeadDetailsRequest leadDetailsRequest, Long leadId) {
        LeadDetails leadDetails = leadDetailsDao.getLeadDetails(leadId);
        leadDetails.setFirstName(leadDetailsRequest.getFirstName());
        leadDetails.setLastName(leadDetailsRequest.getLastName());
        leadDetails.setEmailAddress(leadDetailsRequest.getEmailAddress());
        leadDetails.setPhoneNumber(leadDetailsRequest.getPhoneNumber());
        return leadDetailsDao.updateLeadDetails(leadDetails);
    }

    @Override
    public Long deleteLeadDetailsByLeadId(Long leadId) {
        return leadDetailsDao.deleteLeadDetailsByLeadId(leadId);
    }
}
