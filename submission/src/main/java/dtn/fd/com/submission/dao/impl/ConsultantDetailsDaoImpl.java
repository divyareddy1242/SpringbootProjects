package dtn.fd.com.submission.dao.impl;

import dtn.fd.com.submission.dao.IConsultantDetailsDao;
import dtn.fd.com.submission.models.ConsultantDetails;
import dtn.fd.com.submission.repositories.ConsultantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultantDetailsDaoImpl implements IConsultantDetailsDao {

    @Autowired
    private ConsultantDetailsRepository consultantDetailsRepository;

    @Override
    public List<ConsultantDetails> getAllConsultantDetails() {
        return consultantDetailsRepository.findAll();
    }

    @Override
    public ConsultantDetails createConsultantDetails(ConsultantDetails consultantDetails ) {
        return consultantDetailsRepository.save(consultantDetails);
    }

    @Override
    public ConsultantDetails getConsultantDetails(Long leadId) {
        return consultantDetailsRepository.findById(leadId).orElseThrow();
    }

    @Override
    public ConsultantDetails updateConsultantDetails(ConsultantDetails consultantDetails) {
        return consultantDetailsRepository.save(consultantDetails);
    }

    @Override
    public Long deleteConsultantDetailsById(Long leadId) {
         consultantDetailsRepository.deleteById(leadId);
         return leadId;
    }
}
