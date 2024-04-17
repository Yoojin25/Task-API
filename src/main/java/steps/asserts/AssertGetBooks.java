package steps.asserts;

import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertGetBooks {

    public static void checkGetBooks(List<Book> books, ResponsePositiveSaveAuthor authorSave, String bookTitle) {
        assertThat(books, is(not(empty())));
        assertThat(authorSave.getAuthorId(), equalTo(books.get(0).getAuthor().getId()));
        assertThat(bookTitle, equalTo(books.get(0).getBookTitle()));
    }

    public static void checkGetEmptyListOfBooks(List<Book> books) {
        assertThat(books, is(empty()));
    }
}
