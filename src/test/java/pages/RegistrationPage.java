package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Закрыть рекламу на странице")
    public RegistrationPage removeAdvertisement() {
        removeAds();
        return this;
    }

    @Step("Заполнить поле Имя значением \"{value}\"")
    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    @Step("Заполнить поле Фамилия значением \"{value}\"")
    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("Заполнить поле Email значением \"{value}\"")
    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    @Step("Выбрать пол \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Заполнить поле Номер телефона значением \"{value}\"")
    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    @Step("Заполнить дату рождения: \"{day}\" \"{month}\" \"{year}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Заполнить предметы: \"{subjects}\"")
    public RegistrationPage setSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
        return this;
    }

    @Step("Выбрать хобби: \"{hobbies}\"")
    public RegistrationPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }

    @Step("Загрузить картинку \"{fileName}\"")
    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Заполнить поле Адрес значением \"{value}\"")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Выбрать штат \"{value}\"")
    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать город \"{value}\"")
    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Отправить форму")
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Закрыть результирующую таблицу")
    public RegistrationPage closeResultModal() {
        closeLargeModal.click();
        return this;
    }

    @Step("Получить ячейку результирующей таблицы \"{key}\"")
    public SelenideElement getResultCell(String key) {
        return resultsTable.getCell(key);
    }

    @Step("Получить результирующую таблицу")
    public SelenideElement getResultTable() {
        return resultsTable.getTable();
    }
}
