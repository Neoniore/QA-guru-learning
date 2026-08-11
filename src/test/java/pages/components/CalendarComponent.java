package pages.components;

import static com.codeborne.selenide.Selenide.element;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        element(".react-datepicker__month-select").selectOption(month);
        element(".react-datepicker__year-select").selectOption(year);
        element(".react-datepicker__day--0" + day).click();
    }
}
