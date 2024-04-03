package models.response_negative;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseNegative {
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
