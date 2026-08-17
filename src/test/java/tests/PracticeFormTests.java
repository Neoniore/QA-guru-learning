package tests;

import data.Gender;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static data.RegistrationFormTestData.*;

@DisplayName("Тесты регистрации")
public class PracticeFormTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Заполнение всех полей валидными данными и проверка результирующей таблицы")
    public void positiveRegistrationFormFillingTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(USER_EMAIL)
                .setGender(Gender.Male.description)
                .setUserNumber(USER_NUMBER)
                .setDateOfBirth(DAY, MONTH, YEAR)
                .setSubjects(SUBJECTS)
                .setHobbies(HOBBIES)
                .uploadPicture(PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .submit();

        registrationPage.getResultCell("Student Name").shouldHave(text(FIRST_NAME + " " + LAST_NAME));
        registrationPage.getResultCell("Student Email").shouldHave(text(USER_EMAIL));
        registrationPage.getResultCell("Gender").shouldHave(text(Gender.Male.description));
        registrationPage.getResultCell("Mobile").shouldHave(text(USER_NUMBER));
        registrationPage.getResultCell("Date of Birth").shouldHave(text(DAY + " " + MONTH + "," + YEAR));
        registrationPage.getResultCell("Subjects").shouldHave(text(EXPECTED_SUBJECTS));
        registrationPage.getResultCell("Hobbies").shouldHave(text(String.join(", ", HOBBIES)));
        registrationPage.getResultCell("Picture").shouldHave(text(PICTURE));
        registrationPage.getResultCell("Address").shouldHave(text(CURRENT_ADDRESS));
        registrationPage.getResultCell("State and City").shouldHave(text(STATE + " " + CITY));
    }

    @Test
    @DisplayName("Заполнение обязательных полей валидными данными и проверка результирующей таблицы")
    public void positiveRegistrationFormRequiredFieldsFillingTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(Gender.Other.description)
                .setUserNumber(USER_NUMBER)
                .submit();

        registrationPage.getResultCell("Student Name").shouldHave(text(FIRST_NAME + " " + LAST_NAME));
        registrationPage.getResultCell("Gender").shouldHave(text(Gender.Other.description));
        registrationPage.getResultCell("Mobile").shouldHave(text(USER_NUMBER));
    }

    @Test
    @DisplayName("Ввод цифр в поля ввода Имени и Фамилии")
    @Disabled("Баг - принимается ввод цифр в поля ввода Имени и Фамилии")
    public void shouldRejectDigitsInNameFieldsTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName(NAME_AS_NUMBER)
                .setLastName(NAME_AS_NUMBER)
                .setGender(Gender.Other.description)
                .setUserNumber(USER_NUMBER)
                .submit();

        registrationPage.getResultTable().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Закрытие результирующей таблицы")
    @Disabled("Баг - таблица не закрывается")
    public void closeTableFormAfterSubmittingFormTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(Gender.Other.description)
                .setUserNumber(USER_NUMBER)
                .submit()
                .closeResultModal();

        registrationPage.getResultTable().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Загрузка текстового файла в поле для картинок")
    @Disabled("Баг - принимается загрузка текстового файла в поле для картинок")
    public void shouldRejectNonImageFileUploadTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(Gender.Female.description)
                .setUserNumber(USER_NUMBER)
                .uploadPicture(TEXT_FILE)
                .submit();

        registrationPage.getResultTable().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Заполнение номера телефона буквами")
    public void phoneFieldShouldNotAcceptLettersTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(Gender.Other.description)
                .setUserNumber(USER_NUMBER_AS_STRING)
                .submit();

        registrationPage.getResultTable().shouldNotBe(visible);
    }
}
