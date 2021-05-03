package tests;

import com.codeborne.selenide.Condition;
import helpers.DriverHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@DisplayName("Verify titles on pages")
public class SimpleTests extends TestBase {
    private final String baseUrl = "https://www.google.com";

    @Test
    @Owner("omelyashchik")
    @Feature("Search")
    @DisplayName("Verify search result")
    void checkTitleBlogPage() {
        step("Open " + baseUrl, () ->
                open(baseUrl));

        step("Search 'lviggiano/owner'", () ->
                $(byName("q")).setValue("lviggiano/owner").pressEnter());

        step("Verify title text", () ->
                $("#search div.g a").shouldHave(Condition.href("https://github.com/lviggiano/owner")));
    }
}
