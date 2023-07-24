package dtn.fd.com.submission.dao;

import dtn.fd.com.submission.models.LeadDetails;

import java.util.List;

public interface ILeadDetailsDao {

    List<LeadDetails> getAllLeadDetails();

    LeadDetails getLeadDetails(Long leadId);
    LeadDetails createLeadDetails(LeadDetails leadDetails);

    LeadDetails updateLeadDetails(LeadDetails leadDetails);

    Long deleteLeadDetailsByLeadId(Long leadId);

}
