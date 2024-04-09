package post_test;

import Asserts.AssertSaveAuthor;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.RequestExecutor.saveAuthor;

@Epic("Тестирование POST-методов")
@Story("Сохранение автора, позитивный сценарий")
public class SaveAuthorTest {

    @Test
    @DisplayName("Сохранение нового автора")
    @Description("Сервис сохраняет нового автора в таблицу author, в ответе отображается id сохраненного автора")
    public void saveAuthorTest() {
        String firstName = "Mikhail";
        String familyName = "Lermontov";
        String secondName = "Yuryevich";

        ResponsePositiveSaveAuthor author = saveAuthor(firstName, familyName, secondName);

        AssertSaveAuthor.checkSaveAuthor(author);
    }
}
