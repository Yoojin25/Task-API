package steps.asserts;

import models.response_positive.Book;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertGetBooksXml {

    public static void checkGetBooksXml(List<Book> books) {
        assertThat(books, is(not(empty())));
    }

    public static void checkGetEmptyListOfBooksXml(List<Book> books) {
        assertThat(books, is(empty()));
    }
}
