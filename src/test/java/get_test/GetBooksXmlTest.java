package get_test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import models.request.RequestSaveAuthor;
import models.response_positive.Book;
import models.response_positive.ResponsePositiveSaveAuthor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.AssertGetBooksXml;

import java.util.List;

import static steps.DataGeneration.*;
import static steps.RequestExecutor.*;

@Epic("Тестирование POST-методов")
@Story("Получение книг в XML формате по id автора, позитивный сценарий")
public class GetBooksXmlTest {

    @Test
    @DisplayName("Получение всех книг автора (xml)")
    @Description("Сервис получает информацию обо всех книгах автора по указанному id, в ответе отображается список " +
            "книг в XML формате, статус-код 200")
    public void getBooksXmlTest() {
        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData());
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        saveBook(bookTitleData(), authorSave.getAuthorId(), 201);

        List<Book> books = getBooksXml(authorSave.getAuthorId(), 200);

        AssertGetBooksXml.checkGetBooksXml(books);
    }

    @Test
    @DisplayName("Получение пустого списка книг (xml)")
    @Description("Сервис получает информацию о книгах автора по указанному id, в ответе отображается пустой список " +
            "книг, статус-код 200")
    public void getEmptyListOfBooksXml() {
        RequestSaveAuthor author = new RequestSaveAuthor(firstNameData(), familyNameData(), secondNameData());
        ResponsePositiveSaveAuthor authorSave = saveAuthor(author, 201);

        List<Book> books = getBooksXml(authorSave.getAuthorId(), 200);

        AssertGetBooksXml.checkGetEmptyListOfBooksXml(books);
    }
}
