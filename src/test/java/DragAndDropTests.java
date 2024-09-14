import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false; // используется только для отладки тестов (установить значение true)
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    public void ActionElementsTest() {

        open("/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldNotHave(text("A"));
        $("#column-b").shouldHave(text("A"));

    }

    @Test
    public void DragAndDropElementsTest() {

        open("/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        $("#column-a").shouldNotHave(text("A"));
        $("#column-b").shouldHave(text("A"));

    }
}

