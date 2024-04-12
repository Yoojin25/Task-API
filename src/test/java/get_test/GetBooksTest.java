package get_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertGetBooks;

import java.util.List;

import static steps.RequestExecutor.*;

@Epic("Тестирование GET-методов")
@Story("Получение книг по id автора, позитивный сценарий")
public class GetBooksTest {

    @Test
    @DisplayName("Получение всех книг автора")
    @Description("Сервис получает информацию обо всех книгах автора по указанному id, в ответе отображается список " +
            "книг, статус-код 200")
    public void getBooksTest() {
        RequestSaveAuthor author = new RequestSaveAuthor("Lev", "Tolstoy", "Nikolaevich");
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        saveBook("Voyna i mir", authorSave.getAuthorId(), 201);

        List<Book> books = getBooks(String.valueOf(authorSave.getAuthorId()), 200);

        AssertGetBooks.checkGetBooks(books);
    }

    @Test
    @DisplayName("Получение пустого списка книг")
    @Description("Сервис получает информацию о книгах автора по указанному id, в ответе отображается пустой список " +
            "книг, статус-код 200")
    public void getEmptyListOfBooks() {
        RequestSaveAuthor author = new RequestSaveAuthor("Vladimir", "Mayakovskiy", "Vladimirovich");
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        getBooks(String.valueOf(authorSave.getAuthorId()), 200);
    }
}
