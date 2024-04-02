package models.responce_positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "authors_books")
public class ResponcePositiveGetBooksXml {

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book", required = true)
    private List<Book> books;
}
