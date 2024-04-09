package get_test;

import Asserts.AssertGetBooks;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.response_positive.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static steps.RequestExecutor.getBooks;

@Epic("Тестирование GET-методов")
@Story("Получение книг по id автора, позитивный сценарий")
public class GetBooksTest {

    @Test
    @DisplayName("Получение всех книг автора")
    @Description("Сервис получает информацию обо всех книгах автора по указанному id, в ответе отображается список книг")
    public void getBooksTest() {
        List<Book> books = getBooks("5");

        AssertGetBooks.checkGetBooks(books);
    }
}
