package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@DisplayName("Тесты регистрации")
public class PracticeFormTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Заполнение всех полей валидными данными и проверка результирующей таблицы")
    public void positiveRegistrationFormFillingTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName("Aleks")
                .setLastName("Pechkin")
                .setUserEmail("Aleks@sdfs.com")
                .setGender("Male")
                .setUserNumber("8999999997")
                .setDateOfBirth("20", "July", "1998")
                .setSubjects("E", "computer science")
                .setHobbies("Sports", "Reading", "Music")
                .uploadPicture("image.jpg")
                .setCurrentAddress("Backer street, 221b")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submit();

        registrationPage.getResultCell("Student Name").shouldHave(text("Aleks Pechkin"));
        registrationPage.getResultCell("Student Email").shouldHave(text("Aleks@sdfs.com"));
        registrationPage.getResultCell("Gender").shouldHave(text("Male"));
        registrationPage.getResultCell("Mobile").shouldHave(text("8999999997"));
        registrationPage.getResultCell("Date of Birth").shouldHave(text("20 July,1998"));
        registrationPage.getResultCell("Subjects").shouldHave(text("English, Computer Science"));
        registrationPage.getResultCell("Hobbies").shouldHave(text("Sports, Reading, Music"));
        registrationPage.getResultCell("Picture").shouldHave(text("image.jpg"));
        registrationPage.getResultCell("Address").shouldHave(text("Backer street, 221b"));
        registrationPage.getResultCell("State and City").shouldHave(text("Uttar Pradesh Agra"));
    }

    @Test
    @DisplayName("Заполнение обязательных полей валидными данными и проверка результирующей таблицы")
    public void positiveRegistrationFormRequiredFieldsFillingTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName("Иван")
                .setLastName("Петров")
                .setGender("Other")
                .setUserNumber("89999999999")
                .submit();

        registrationPage.getResultCell("Student Name").shouldHave(text("Иван Петров"));
        registrationPage.getResultCell("Gender").shouldHave(text("Other"));
        registrationPage.getResultCell("Mobile").shouldHave(text("8999999999"));
    }

    @Test
    @DisplayName("Ввод цифр в поля ввода Имени и Фамилии")
    public void shouldRejectDigitsInNameFieldsTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName("00000")
                .setLastName("99999")
                .setGender("Other")
                .setUserNumber("89999999999")
                .submit();

        registrationPage.getResultTable().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Закрытие результирующей таблицы")
    public void closeTableFormAfterSubmittingFormTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName("Иван")
                .setLastName("Петров")
                .setGender("Other")
                .setUserNumber("89999999999")
                .submit()
                .closeResultModal();

        registrationPage.getResultTable().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Загрузка текстового файла в поле для картинок")
    public void shouldRejectNonImageFileUploadTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName("Алёна")
                .setLastName("Иванова")
                .setGender("Female")
                .setUserNumber("89993339933")
                .uploadPicture("textFile.txt")
                .submit();

        registrationPage.getResultTable().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Заполнение номера телефона буквами")
    public void phoneFieldShouldNotAcceptLettersTest() {
        registrationPage.openPage()
                .removeAdvertisement()
                .setFirstName("Алёна")
                .setLastName("Иванова")
                .setGender("Other")
                .setUserNumber("ggggggggggg")
                .submit();

        registrationPage.getResultTable().shouldNotBe(visible);
    }
}
