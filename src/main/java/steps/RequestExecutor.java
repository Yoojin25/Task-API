package steps;

import models.request.Author;
import models.request.RequestGetBooksXml;
import models.request.RequestSaveAuthor;
import models.request.RequestSaveBook;
import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;
import models.response_positive.ResponsePositiveSaveBook;

import java.util.List;

import static io.restassured.RestAssured.given;
import static steps.Specification.requestSpec;
import static steps.Specification.requestSpecXml;

public class RequestExecutor {

    public static ResponsePositiveSaveAuthor saveAuthor(RequestSaveAuthor author) {

        return given()
                .spec(requestSpec())
                .body(author)
                .when()
                .post(Endpoints.SAVE_AUTHOR)
                .as(ResponsePositiveSaveAuthor.class);
    }

    public static ResponsePositiveSaveBook saveBook(String bookTitle, long id) {
        Author author = new Author(id);
        RequestSaveBook book = new RequestSaveBook(bookTitle, author);

        return given()
                .spec(requestSpec())
                .body(book)
                .when()
                .post(Endpoints.SAVE_BOOK)
                .as(ResponsePositiveSaveBook.class);
    }

    public static List<Book> getBooks(String id) {

        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.GET_BOOKS)
                .then()
                .extract()
                .jsonPath()
                .getList(".", Book.class);
    }

    public static List<Book> getBooksXml(long authorId) {
        RequestGetBooksXml idXml = new RequestGetBooksXml();
        idXml.setAuthorId(authorId);

        return given()
                .spec(requestSpecXml())
                .body(idXml)
                .when()
                .post(Endpoints.GET_BOOKS_XML)
                .then()
                .extract()
                .xmlPath()
                .getList(".", Book.class);
    }
}
