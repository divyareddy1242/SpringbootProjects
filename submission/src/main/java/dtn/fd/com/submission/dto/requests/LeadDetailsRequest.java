package dtn.fd.com.submission.dto.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadDetailsRequest {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
}
