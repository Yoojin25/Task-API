package models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "author")
public class RequestGetBooksXml {

    @XmlElement(name = "author_id", required = true)
    private long authorId;
}
