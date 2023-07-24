package dtn.fd.com.submission.dto.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultantDetailsRequest {

    private Long leadId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

}
