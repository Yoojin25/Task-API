package entity;

import lombok.Data;

@Data
public class TableBook {
    private long id;
    private String bookTitle;
    private long authorId;
}
