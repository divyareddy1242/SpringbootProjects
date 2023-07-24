package dtn.fd.com.submission.dao.impl;

import dtn.fd.com.submission.dao.ILeadDetailsDao;
import dtn.fd.com.submission.models.LeadDetails;
import dtn.fd.com.submission.repositories.LeadDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeadDetailsDaoImpl implements ILeadDetailsDao {

    @Autowired
    private LeadDetailsRepository leadDetailsRepository;

    @Override
    public List<LeadDetails> getAllLeadDetails() {
        return leadDetailsRepository.findAll();
    }

    @Override
    public LeadDetails createLeadDetails(LeadDetails leadDetails ) {
        return leadDetailsRepository.save(leadDetails);
    }

    @Override
    public LeadDetails getLeadDetails(Long leadId) {
        return leadDetailsRepository.findById(leadId).orElseThrow();
    }

    @Override
    public LeadDetails updateLeadDetails(LeadDetails leadDetails) {
        return leadDetailsRepository.save(leadDetails);
    }

    @Override
    public Long deleteLeadDetailsByLeadId(Long leadId) {
         leadDetailsRepository.deleteById(leadId);
         return leadId;
    }
}
