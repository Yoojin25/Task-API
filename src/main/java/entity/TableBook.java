package entity;

import lombok.Data;

import java.util.Date;

@Data
public class TableBook {
    private long id;
    private String bookTitle;
    private long authorId;
    private Date updated;
}
