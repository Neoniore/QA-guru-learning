package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends BasePage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTable = new ResultsTableComponent();

    SelenideElement firstName = $("[id='firstName']");
    SelenideElement lastName = $("[id='lastName']");
    SelenideElement userEmail = $("[id='userEmail']");
    SelenideElement genderWrapper = $("[id='genterWrapper']");
    SelenideElement userNumber = $("[id='userNumber']");
    SelenideElement dateOfBirthInput = element("[id='dateOfBirthInput']");
    SelenideElement subjectsInput = $("[id='subjectsInput']");
    SelenideElement hobbiesWrapper = $("[id='hobbiesWrapper']");
    SelenideElement uploadPictureInput = $("[id='uploadPicture']");
    SelenideElement currentAddress = $("[id='currentAddress']");
    SelenideElement stateInput = $("[id='react-select-3-input']");
    SelenideElement cityInput = $("[id='react-select-4-input']");
    SelenideElement submitButton = $("[id='submit']");
    SelenideElement closeLargeModal = $("[id='closeLargeModal']");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeAdvertisement() {
        removeAds();
        return this;
    }

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

    public RegistrationPage setSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
        return this;
    }

    public RegistrationPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage closeResultModal() {
        closeLargeModal.click();
        return this;
    }

    public SelenideElement getResultCell(String key) {
        return resultsTable.getCell(key);
    }

    public SelenideElement getResultTable() {
        return resultsTable.getTable();
    }
}
