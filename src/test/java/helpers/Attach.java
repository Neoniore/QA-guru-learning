package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
    @Attachment(value = "{attachName}}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return screenshot(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html") // or text/html
    public static byte[] pageSource() {
        WebDriver driver = Objects.requireNonNull(
                getWebDriver(),
                "WebDriver is not initialized or has already been closed"
        );

        String source = Objects.requireNonNull(
                driver.getPageSource(),
                "WebDriver returned null page source"
        );

        return source.getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        String videoUrl = getVideoUrl();

        return """
            <html>
              <body>
                <video width='100%%' height='100%%' controls autoplay>
                  <source src='%s' type='video/mp4'>
                </video>
              </body>
            </html>
            """.formatted(videoUrl);
    }

    public static String getVideoUrl() {
        return "https://selenoid.qa.guru/video/%s.mp4".formatted(sessionId());
    }
}
