package dtn.fd.com.submission.models;

import dtn.fd.com.submission.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "submission")
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Long submissionId;

    @Column(name ="consultant_id")
    private Long consultantId ;

    @Column(name = "submission_date")
     private LocalDate submissionDate;

    @Column(name = "vendor_company")
    private String vendorCompany;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "vendor_email_address")
    private String vendorEmailAddress;

    @Column(name = "vendor_phone_number")
    private String vendorPhoneNumber;

    @Column(name = "implementation_partner")
    private String implementationPartner;

    @Column(name = "client_name")
    private String clientName ;

    @Column(name = "pay_rate")
    private Double payRate;

    @Column(name = "submission_status")
    private Status submissionStatus;

    @Column(name = "submission_type")
    private String submissionType;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private Integer zip;

}
