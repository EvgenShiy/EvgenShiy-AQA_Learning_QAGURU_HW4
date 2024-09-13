import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GithubEnterpriseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false; // используется только для отладки тестов (установить значение true)
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    public void NavigateToEnterpriseTest() {

        open("https://github.com");

        $$("nav ul li").findBy(text("Solutions")).hover();

        $$("header a").findBy(text("Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

    }
}
