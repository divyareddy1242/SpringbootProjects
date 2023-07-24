package dtn.fd.com.submission.dto.response;

import dtn.fd.com.submission.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubmissionResponse {

    private Long submissionId;
    private Long consultantId ;
    private LocalDate submissionDate;
    private String vendorCompany;
    private String vendorName;
    private String vendorEmailAddress;
    private String vendorPhoneNumber;
    private String implementationPartner;
    private String clientName ;
    private Double payRate;
    private Status submissionStatus;
    private String submissionType;
    private String city;
    private String state;
    private Integer zip;
}
