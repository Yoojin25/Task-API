package post_test;

import Asserts.AssertSaveBook;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.response_positive.ResponsePositiveSaveBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.RequestExecutor.saveBook;

@Epic("Тестирование POST-методов")
@Story("Сохранение книги, позитивный сценарий")
public class SaveBookTest {

    @Test
    @DisplayName("Сохранение новой книги")
    @Description("Сервис сохраняет новую книгу в таблицу book, в ответе отображается id сохраненной книги")
    public void saveBookTest() {
        ResponsePositiveSaveBook book = saveBook("Parus", 5);

        AssertSaveBook.checkSaveBook(book);
    }
}
