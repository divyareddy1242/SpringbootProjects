package dtn.fd.com.submission.services;

import dtn.fd.com.submission.dto.requests.LeadDetailsRequest;
import dtn.fd.com.submission.models.LeadDetails;

import java.util.List;

public interface ILeadDetailsService {
    List<LeadDetails> getAllLeadDetails();

    LeadDetails createLeadDetails(LeadDetailsRequest leadDetailsRequest);
    LeadDetails getLeadDetails(Long leadId);

    LeadDetails updateLeadDetails(LeadDetailsRequest leadDetailsRequest,Long leadId);

    Long deleteLeadDetailsByLeadId(Long leadId);

}
