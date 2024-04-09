package Asserts;

import models.response_positive.Book;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertGetBooks {

    public static void checkGetBooks(List<Book> books) {
        assertThat(books, is(not(empty())));
    }
}
