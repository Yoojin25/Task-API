package steps;

import models.request.Author;
import models.request.RequestGetBooksXml;
import models.request.RequestSaveAuthor;
import models.request.RequestSaveBook;
import models.response_negative.ResponseNegative;
import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;
import models.response_positive.ResponsePositiveSaveBook;

import java.util.List;

import static io.restassured.RestAssured.given;
import static steps.Specification.*;

public class RequestExecutor {

    public static ResponsePositiveSaveAuthor saveAuthor(RequestSaveAuthor author, int expectedStatusCode) {

        return given()
                .spec(requestSpec())
                .body(author)
                .when()
                .post(Endpoints.SAVE_AUTHOR)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .as(ResponsePositiveSaveAuthor.class);
    }

    public static ResponsePositiveSaveBook saveBook(String bookTitle, long id, int expectedStatusCode) {
        Author author = new Author(id);
        RequestSaveBook book = new RequestSaveBook(bookTitle, author);

        return given()
                .spec(requestSpec())
                .body(book)
                .when()
                .post(Endpoints.SAVE_BOOK)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .as(ResponsePositiveSaveBook.class);
    }

    public static List<Book> getBooks(String id, int expectedStatusCode) {

        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.GET_BOOKS)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .jsonPath()
                .getList(".", Book.class);
    }

    public static List<Book> getBooksXml(long authorId, int expectedStatusCode) {
        RequestGetBooksXml idXml = new RequestGetBooksXml();
        idXml.setAuthorId(authorId);

        return given()
                .spec(requestSpecXml())
                .body(idXml)
                .when()
                .post(Endpoints.GET_BOOKS_XML)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .xmlPath()
                .getList("authors_books.books.book", Book.class);
    }

    public static ResponseNegative saveBookNegative(String bookTitle, long id, int expectedStatusCode) {
        Author author = new Author(id);
        RequestSaveBook book = new RequestSaveBook(bookTitle, author);

        return given()
                .spec(requestSpec())
                .body(book)
                .when()
                .post(Endpoints.SAVE_BOOK)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .as(ResponseNegative.class);
    }

    public static ResponseNegative getBooksNegative(String id, int expectedStatusCode) {

        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoints.GET_BOOKS)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .as(ResponseNegative.class);
    }

    public static ResponseNegative getBooksXmlNegative(long authorId, int expectedStatusCode) {
        RequestGetBooksXml idXml = new RequestGetBooksXml();
        idXml.setAuthorId(authorId);

        return given()
                .spec(requestSpecXml())
                .body(idXml)
                .when()
                .post(Endpoints.GET_BOOKS_XML)
                .then()
                .spec(responseSpec(expectedStatusCode))
                .extract()
                .as(ResponseNegative.class);
    }
}
