package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {

    @BeforeAll
    public static void startUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "151.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.baseUrl = System.getProperty("base-url","https://demoqa.com"); // в переменную
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false")); // в переменную

        SelenideLogger.addListener("allure", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true)
        );

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.qa.guru/wd/hub"); // в переменную
    }

    @AfterEach
    public void attachmentsAndTearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
