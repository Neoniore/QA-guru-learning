package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    //sostoyanie
    SelenideElement firstName = $("[id='firstName']");
    SelenideElement lastName = $("[id='lastName']");
    SelenideElement userEmail = $("[id='userEmail']");
    SelenideElement genderWrapper = $("[id='genterWrapper']");
    SelenideElement userNumber = $("[id='userNumber']");
    SelenideElement dateOfBirthInput = element("[id='dateOfBirthInput']");


    //actions
    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
}
