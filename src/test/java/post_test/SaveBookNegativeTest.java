package post_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.RequestExecutor.*;

@Epic("Тестирование POST-методов")
@Story("Сохранение книги, негативный сценарий")
public class SaveBookNegativeTest {

    @Test
    @DisplayName("Сохранение новой книги без указания bookTitle")
    @Description("Сервис не сохраняет новую книгу в таблицу book, статус-код 400")
    public void saveBookWithEmptyBookTitle() {
        RequestSaveAuthor author = new RequestSaveAuthor("Author", "Author", "Author");
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        saveBook("", authorSave.getAuthorId(), 400);
    }

    @Test
    @DisplayName("Сохранение новой книги автора, который не существует в таблице author")
    @Description("Сервис не сохраняет новую книгу в таблицу book, статус-код 409")
    public void saveBookNonExistAuthor() {
        saveBook("Book title", 1234567, 409);
    }

    @Test
    @DisplayName("Сохранение новой книги c bookTitle превышающим максимальную длину")
    @Description("Сервис не сохраняет новую книгу в таблицу book, статус-код 400")
    public void bookTitleGreaterThanMaxLength() {
        RequestSaveAuthor author = new RequestSaveAuthor("Author2", "Author2", "Author2");
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        saveBook("Book title Book title Book title Book title Book ti", authorSave.getAuthorId(), 400);
    }
}
