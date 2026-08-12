package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ResultsTableComponent {
    SelenideElement table = $(".table-responsive");

    public SelenideElement getCell(String key) {
        return table.$(byText(key)).parent();
    }

    public SelenideElement getTable() {
        return table;
    }
}
