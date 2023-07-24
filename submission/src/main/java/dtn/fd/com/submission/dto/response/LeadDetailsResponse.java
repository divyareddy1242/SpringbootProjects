package dtn.fd.com.submission.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadDetailsResponse {
    private static final long serialVersionUID = 123456799L;

    private Long leadId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;
}
