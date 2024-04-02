package models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestSaveAuthor {
    private String firstName;
    private String familyName;
    private String secondName;
}
