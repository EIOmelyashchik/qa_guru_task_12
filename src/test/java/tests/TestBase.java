package tests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.DriverHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static helpers.AttachmentHelper.*;

public class TestBase {
    @BeforeAll
    static void setUp() {
        DriverHelper.configureDriver();
    }

    @AfterEach
    public void addAttachments(){
        attachScreenshot("Last screenshot");
        attachPageSource();
        if (Configuration.browser.equals(Browsers.CHROME))
            attachAsText("Browser console logs", DriverHelper.getConsoleLogs());
        if (DriverHelper.isVideoOn())
            attachVideo(DriverHelper.getSessionId());
        WebDriverRunner.closeWebDriver();
    }
}
