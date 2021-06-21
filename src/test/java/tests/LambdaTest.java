package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest extends TestBase {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    @Tag("terminal")
    public void issueSearchLambdaTest() {
        step("Открываем главную страницу", (s) -> {
            s.parameter("URL", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(byAttribute("href", "/" + REPOSITORY)).click();
        });
        step("Открываем таб Issues в репозитории", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем, что Issue с номером " + ISSUE_NUMBER + " существет", (s) -> {
            s.parameter("Number", ISSUE_NUMBER);
            $(withText("#" + ISSUE_NUMBER)).should(visible);
        });
    }
}
