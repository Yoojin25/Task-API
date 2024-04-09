package get_test;

import Asserts.AssertGetBooksXml;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.response_positive.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static steps.RequestExecutor.getBooksXml;

@Epic("Тестирование POST-методов")
@Story("Получение книг в XML формате по id автора, позитивный сценарий")
public class GetBooksXmlTest {

    @Test
    @DisplayName("Получение всех книг автора (xml)")
    @Description("Сервис получает информацию обо всех книгах автора по указанному id, в ответе отображается список " +
            "книг в XML формате")
    public void getBooksXmlTest() {
        List<Book> books = getBooksXml(5L);

        AssertGetBooksXml.checkGetBooksXml(books);
    }
}
