package dtn.fd.com.submission.controllers;

import dtn.fd.com.submission.dto.requests.LeadDetailsRequest;
import dtn.fd.com.submission.dto.response.LeadDetailsResponse;
import dtn.fd.com.submission.models.LeadDetails;
import dtn.fd.com.submission.services.ILeadDetailsService;
import dtn.fd.com.submission.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/lead-details")
public class LeadDetailsController {

    @Autowired
    private ILeadDetailsService leadDetailsService;

    @GetMapping
    ResponseEntity<List<LeadDetailsResponse>> getAllLeadDetails(){
        List<LeadDetails> leadDetailsList=leadDetailsService.getAllLeadDetails();
        List<LeadDetailsResponse> leadDetailsResponseList= ObjectMapperUtils.mapAll(leadDetailsList, LeadDetailsResponse.class);
        return ResponseEntity.ok(leadDetailsResponseList);
    }

    @GetMapping(path = "{lead-id}")
    ResponseEntity<LeadDetailsResponse> getLeadDetails(@PathVariable(name = "lead-id") Long leadId){
        LeadDetails leadDetails=leadDetailsService.getLeadDetails(leadId);
        LeadDetailsResponse leadDetailsResponse= ObjectMapperUtils.map(leadDetails, LeadDetailsResponse.class);
        return ResponseEntity.ok(leadDetailsResponse);
    }

    @PostMapping
    ResponseEntity<LeadDetailsResponse> createLeadDetails(@RequestBody LeadDetailsRequest leadDetailsRequest){
        LeadDetails leadDetails=leadDetailsService.createLeadDetails(leadDetailsRequest);
        LeadDetailsResponse leadDetailsResponse=ObjectMapperUtils.map(leadDetails, LeadDetailsResponse.class);
        return new ResponseEntity<>(leadDetailsResponse, HttpStatus.CREATED);
    }

    @PatchMapping(path = "{lead-id}")
    ResponseEntity<LeadDetailsResponse> updateLeadDetails(@PathVariable(name = "lead-id") Long leadId,@RequestBody LeadDetailsRequest leadDetailsRequest){
        LeadDetails leadDetails=leadDetailsService.updateLeadDetails(leadDetailsRequest,leadId);
        LeadDetailsResponse leadDetailsResponse=ObjectMapperUtils.map(leadDetails, LeadDetailsResponse.class);
        return new ResponseEntity<>(leadDetailsResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "{lead-id}")
    ResponseEntity<String> deleteLeadDetailsById(@PathVariable(name = "lead-id") Long leadId){
        Long leadDetailsID=leadDetailsService.deleteLeadDetailsByLeadId(leadId);
        return new ResponseEntity<>("Successfully Deleted",HttpStatus.NO_CONTENT);
    }

}
