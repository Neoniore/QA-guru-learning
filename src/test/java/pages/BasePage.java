package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage {
    public void removeAds() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }
}
