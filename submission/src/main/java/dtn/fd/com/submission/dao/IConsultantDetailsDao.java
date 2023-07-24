package dtn.fd.com.submission.dao;

import dtn.fd.com.submission.models.ConsultantDetails;


import java.util.List;

public interface IConsultantDetailsDao {

    List<ConsultantDetails> getAllConsultantDetails();

    ConsultantDetails getConsultantDetails(Long consultantId);
    ConsultantDetails createConsultantDetails(ConsultantDetails consultantDetails);

    ConsultantDetails updateConsultantDetails(ConsultantDetails consultantDetails);

    Long deleteConsultantDetailsById(Long consultantId);
}
