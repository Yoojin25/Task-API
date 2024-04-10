package post_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertSaveAuthor;

import static steps.RequestExecutor.saveAuthor;

@Epic("Тестирование POST-методов")
@Story("Сохранение автора, позитивный сценарий")
public class SaveAuthorTest {

    @Test
    @DisplayName("Сохранение нового автора")
    @Description("Сервис сохраняет нового автора в таблицу author, в ответе отображается id сохраненного автора")
    public void saveAuthorTest() {
        RequestSaveAuthor author = new RequestSaveAuthor("test","testt", "testtt");
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author);

        AssertSaveAuthor.checkSaveAuthor(authorSave);
    }
}
