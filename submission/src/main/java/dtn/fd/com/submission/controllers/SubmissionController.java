package dtn.fd.com.submission.controllers;

import dtn.fd.com.submission.dto.requests.SubmissionRequest;
import dtn.fd.com.submission.dto.response.SubmissionResponse;
import dtn.fd.com.submission.mapper.SubmissionModelMapper;
import dtn.fd.com.submission.models.Submission;
import dtn.fd.com.submission.services.ISubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/submission")
public class SubmissionController {

    @Autowired
    private ISubmissionService submissionService;

    @GetMapping
    public ResponseEntity<List<SubmissionResponse>> getSubmissionList(@RequestParam(name = "lead", required = false) String lead){
        List<Submission> submissionList=submissionService.getAllSubmission(lead);
        List<SubmissionResponse> submissionResponseList=SubmissionModelMapper.convertModelToSubmissionResponse(submissionList);
        return new ResponseEntity<>(submissionResponseList, HttpStatus.OK);
    }


    @GetMapping(path = "{submission-id}")
    public ResponseEntity<SubmissionResponse> getSubmissionBySerialNumber(@PathVariable(name = "submission-id") Long submissionId){
        Submission submission=submissionService.getSubmissionBySubmissionId(submissionId);
        SubmissionResponse submissionResponse=SubmissionModelMapper.convertModelToSubmissionResponse(submission);
        return new ResponseEntity<>(submissionResponse, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<SubmissionResponse> createSubmission(@RequestBody SubmissionRequest submissionRequest){
          Submission submission=submissionService.createSubmission(submissionRequest);
          SubmissionResponse submissionResponse=SubmissionModelMapper.convertModelToSubmissionResponse(submission);
          return new ResponseEntity<>(submissionResponse,HttpStatus.CREATED);
    }

    @PatchMapping(path = "{submission-id}")
    public ResponseEntity<SubmissionResponse> updateSubmissionBySerialId(@PathVariable(name = "submission-id") Long submissionId,@RequestBody SubmissionRequest submissionRequest){
          Submission submission=submissionService.updateSubmissionBySubmissionId(submissionId,submissionRequest);
          SubmissionResponse submissionResponse=SubmissionModelMapper.convertModelToSubmissionResponse(submission);
          return ResponseEntity.ok(submissionResponse);
    }

    @DeleteMapping(path = "{submission-id}")
    public ResponseEntity<String> deleteSubmissionBySerialId(@PathVariable(name = "submission-id") Long submissionId){
          Long id=submissionService.deleteSubmissionBySubmissionId(submissionId);
          return new ResponseEntity<>("Deleted Successfully!!",HttpStatus.NO_CONTENT);
    }
}
