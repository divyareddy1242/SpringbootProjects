package dtn.fd.com.submission.controllers;

import dtn.fd.com.submission.dto.requests.ConsultantDetailsRequest;
import dtn.fd.com.submission.dto.response.ConsultantDetailsResponse;
import dtn.fd.com.submission.models.ConsultantDetails;
import dtn.fd.com.submission.services.IConsultantDetailsService;
import dtn.fd.com.submission.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/consultant-details")
public class ConsultantDetailsController {

    @Autowired
    private IConsultantDetailsService consultantDetailsService;

    @GetMapping
    ResponseEntity<List<ConsultantDetailsResponse>> getAllConsultantDetails(){
        List<ConsultantDetails> consultantDetailsList=consultantDetailsService.getAllConsultantDetails();
        List<ConsultantDetailsResponse> consultantDetailsResponseList= ObjectMapperUtils.mapAll(consultantDetailsList, ConsultantDetailsResponse.class);
        return ResponseEntity.ok(consultantDetailsResponseList);
    }

    @GetMapping(path = "{consultant-id}")
    ResponseEntity<ConsultantDetailsResponse> getConsultantDetails(@PathVariable(name = "consultant-id") Long consultantId){
        ConsultantDetails consultantDetails=consultantDetailsService.getConsultantDetailsByConsultantId(consultantId);
        ConsultantDetailsResponse consultantDetailsResponse= ObjectMapperUtils.map(consultantDetails, ConsultantDetailsResponse.class);
        return ResponseEntity.ok(consultantDetailsResponse);
    }

    @PostMapping
    ResponseEntity<ConsultantDetailsResponse> createConsultantDetails(@RequestBody ConsultantDetailsRequest consultantDetailsRequest){
        ConsultantDetails leadDetails=consultantDetailsService.createConsultantDetails(consultantDetailsRequest);
        ConsultantDetailsResponse consultantDetailsResponse=ObjectMapperUtils.map(leadDetails, ConsultantDetailsResponse.class);
        return new ResponseEntity<>(consultantDetailsResponse, HttpStatus.CREATED);
    }

    @PatchMapping(path = "{consultant-id}")
    ResponseEntity<ConsultantDetailsResponse> updateConsultantDetails(@PathVariable(name = "consultant-id") Long consultantId,@RequestBody ConsultantDetailsRequest leadDetailsRequest){
        ConsultantDetails leadDetails=consultantDetailsService.updateConsultantDetails(leadDetailsRequest,consultantId);
        ConsultantDetailsResponse consultantDetailsResponse=ObjectMapperUtils.map(leadDetails, ConsultantDetailsResponse.class);
        return new ResponseEntity<>(consultantDetailsResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "{consultant-id}")
    ResponseEntity<String> deleteConsultantDetailsById(@PathVariable(name = "consultant-id") Long consultantId){
        Long leadDetailsID=consultantDetailsService.deleteConsultantDetailsByConsultantId(consultantId);
        return new ResponseEntity<>("Successfully Deleted",HttpStatus.NO_CONTENT);
    }

}
