package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@DisplayName("Verify google search results")
public class SimpleTests extends TestBase {
    private final String baseUrl = "https://www.google.com";
    private final String searchKey = "lviggiano/owner";
    private final String expectedUrl = "https://github.com/lviggiano/owner";

    @Test
    @Owner("omelyashchik")
    @Feature("Search")
    @DisplayName("Verify google search result")
    void checkGoogleSearchResult() {
        step("Open " + baseUrl, () ->
                open(baseUrl));

        step(String.format("Search '%s'", searchKey), () ->
                $(byName("q")).setValue(searchKey).pressEnter());

        step(String.format("Verify that search result contains link to '%s'", expectedUrl), () ->
                $("#search div.g a").shouldHave(Condition.href(expectedUrl)));
    }
}
