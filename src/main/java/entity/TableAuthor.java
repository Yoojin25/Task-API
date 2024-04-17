package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class TableAuthor {

    @XmlElement(name = "id", required = true)
    private long id;

    @XmlElement(name = "first_name", required = true)
    private String firstName;

    @XmlElement(name = "family_name", required = true)
    private String familyName;

    @XmlElement(name = "second_name")
    private String secondName;

    @XmlElement(name = "birth_date")
    private String birthDate;
}
