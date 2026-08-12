package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        SelenideElement monthPicker = $(".react-datepicker__month-select");
        SelenideElement yearPicker = $(".react-datepicker__year-select");
        SelenideElement dayPicker = $(".react-datepicker__day--0" + day);

        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        dayPicker.click();
    }
}
