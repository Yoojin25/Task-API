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
    @Description("Сервис получает информацию обо всех книгах автора по указанному id, в ответе отображается список книг")
    public void getBooksTest() {
        RequestSaveAuthor author = new RequestSaveAuthor("Lev", "Tolstoy", "Nikolaevich");
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author);

        saveBook("Voyna i mir", authorSave.getAuthorId());

        List<Book> books = getBooks(String.valueOf(authorSave.getAuthorId()));

        AssertGetBooks.checkGetBooks(books);
    }
}
