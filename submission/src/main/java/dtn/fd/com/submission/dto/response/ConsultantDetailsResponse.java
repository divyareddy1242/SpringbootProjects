package dtn.fd.com.submission.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultantDetailsResponse {

    private Long consultantId;

    private Long leadId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

}
