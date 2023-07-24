package dtn.fd.com.submission.services.impl;

import dtn.fd.com.submission.dao.IConsultantDetailsDao;
import dtn.fd.com.submission.dto.requests.ConsultantDetailsRequest;
import dtn.fd.com.submission.models.ConsultantDetails;
import dtn.fd.com.submission.services.IConsultantDetailsService;
import dtn.fd.com.submission.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantDetailServiceImpl implements IConsultantDetailsService {

    @Autowired
    private IConsultantDetailsDao consultantDetailsDao;

    @Override
    public List<ConsultantDetails> getAllConsultantDetails() {
        return consultantDetailsDao.getAllConsultantDetails();
    }

    @Override
    public ConsultantDetails createConsultantDetails(ConsultantDetailsRequest consultantDetailsRequest) {
        ConsultantDetails consultantDetails = ObjectMapperUtils.map(consultantDetailsRequest, ConsultantDetails.class);
        return consultantDetailsDao.createConsultantDetails(consultantDetails);
    }

    @Override
    public ConsultantDetails getConsultantDetailsByConsultantId(Long consultantId) {
        return consultantDetailsDao.getConsultantDetails(consultantId);
    }

    @Override
    public ConsultantDetails updateConsultantDetails(ConsultantDetailsRequest consultantDetailsRequest, Long consultantId) {
        ConsultantDetails leadDetails = consultantDetailsDao.getConsultantDetails(consultantId);
        leadDetails.setFirstName(consultantDetailsRequest.getFirstName());
        leadDetails.setLastName(consultantDetailsRequest.getLastName());
        leadDetails.setEmailAddress(consultantDetailsRequest.getEmailAddress());
        leadDetails.setPhoneNumber(consultantDetailsRequest.getPhoneNumber());
        return consultantDetailsDao.updateConsultantDetails(leadDetails);
    }

    @Override
    public Long deleteConsultantDetailsByConsultantId(Long consultantId) {
        return consultantDetailsDao.deleteConsultantDetailsById(consultantId);
    }
}
