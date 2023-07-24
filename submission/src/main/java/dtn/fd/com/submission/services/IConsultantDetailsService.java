package dtn.fd.com.submission.services;

import dtn.fd.com.submission.dto.requests.ConsultantDetailsRequest;
import dtn.fd.com.submission.models.ConsultantDetails;

import java.util.List;

public interface IConsultantDetailsService {
    List<ConsultantDetails> getAllConsultantDetails();

    ConsultantDetails createConsultantDetails(ConsultantDetailsRequest consultantDetailsRequest);
    ConsultantDetails getConsultantDetailsByConsultantId(Long consultantId);

    ConsultantDetails updateConsultantDetails(ConsultantDetailsRequest consultantDetailsRequest,Long consultantId);

    Long deleteConsultantDetailsByConsultantId(Long consultantId);

}
