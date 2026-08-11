package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultsTableComponent {
    SelenideElement table = $(".table-responsive");

    public SelenideElement getCell(String label) {
        return $x("//tr[td[text()='" + label + "']]/td[2]");
    }

    public SelenideElement getTable() {
        return table;
    }
}
