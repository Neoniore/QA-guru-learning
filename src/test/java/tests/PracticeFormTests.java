package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тесты регистрации")
public class PracticeFormTests extends BaseTest {

    @DisplayName("Регистрация с валидным заполнением всех полей")
    @ParameterizedTest()
    @CsvFileSource(resources = "/test_data/positiveRegistrationFormFillingTest.csv")
    public void positiveRegistrationFormFillingTest(String name, String surname, String phone) {
        $("[id='firstName']").setValue(name);
        $("[id='lastName']").setValue(surname);
        $("[id='userEmail']").setValue("Aleks@sdfs.com");
        $("[id='genterWrapper']").$(byText("Male")).click();
        $("[id='userNumber']").setValue(phone);
        $("[id='dateOfBirthInput']").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--001").click();
        $("[id='subjectsInput']").setValue("E")
                .pressEnter()
                .setValue("computer science")
                .pressEnter();
        $("[id='hobbiesWrapper']").$(byText("Sports")).click();
        $("[id='hobbiesWrapper']").$(byText("Reading")).click();
        $("[id='hobbiesWrapper']").$(byText("Music")).click();

        $("[id='uploadPicture']").uploadFromClasspath("image.jpg");

        $("[id='currentAddress']").setValue("Backer street, 221b");

        $("[id='react-select-3-input']").setValue("Uttar Pradesh").pressEnter();
        $("[id='react-select-4-input']").setValue("Agra").pressEnter();


        $("[id='submit']").click();


        $x("//tr[td[text()='Student Name']]/td[2]")
                .shouldBe(text(name + " " + surname));
        $x("//tr[td[text()='Student Email']]/td[2]")
                .shouldBe(text("Aleks@sdfs.com"));
        $x("//tr[td[text()='Gender']]/td[2]")
                .shouldBe(text("Male"));
        $x("//tr[td[text()='Mobile']]/td[2]")
                .shouldBe(text(phone));
        $x("//tr[td[text()='Date of Birth']]/td[2]")
                .shouldBe(text("01 July,1998"));
        $x("//tr[td[text()='Subjects']]/td[2]")
                .shouldBe(text("English, Computer Science"));
        $x("//tr[td[text()='Hobbies']]/td[2]")
                .shouldBe(text("Sports, Reading, Music"));
        $x("//tr[td[text()='Picture']]/td[2]")
                .shouldBe(text("image.jpg"));
        $x("//tr[td[text()='Address']]/td[2]")
                .shouldBe(text("Backer street, 221b"));
        $x("//tr[td[text()='State and City']]/td[2]")
                .shouldBe(text("Uttar Pradesh Agra"));
    }

    @Test
    public void positiveRegistrationFormRequiredFieldsFillingTest() {
        $("[id='firstName']").setValue("Иван");
        $("[id='lastName']").setValue("Петров");
        $("[id='genterWrapper']").$(byText("Other")).click();
        $("[id='userNumber']").setValue("89999999999");


        $("[id='submit']").click();


        $x("//tr[td[text()='Student Name']]/td[2]")
                .shouldBe(text("Иван Петров"));
        $x("//tr[td[text()='Gender']]/td[2]")
                .shouldBe(text("Other"));
        $x("//tr[td[text()='Mobile']]/td[2]")
                .shouldBe(text("8999999999"));
    }

    @Test
    public void shouldRejectDigitsInNameFieldsTest() {
        $("[id='firstName']").setValue("00000");
        $("[id='lastName']").setValue("99999");
        $("[id='genterWrapper']").$(byText("Other")).click();
        $("[id='userNumber']").setValue("89999999999");


        $("[id='submit']").click();


        $(".table-responsive").shouldNotBe(visible);
    }

    @Test
    public void closeTableFormAfterSubmittingFormTest() {
        $("[id='firstName']").setValue("Иван");
        $("[id='lastName']").setValue("Петров");
        $("[id='genterWrapper']").$(byText("Other")).click();
        $("[id='userNumber']").setValue("89999999999");


        $("[id='submit']").click();
        $("[id='closeLargeModal']").click();


        $(".table-responsive").shouldNotBe(visible);
    }

    @Test
    public void shouldRejectNonImageFileUploadTest() {
        $("[id='firstName']").setValue("Алёна");
        $("[id='lastName']").setValue("Иванова");
        $("[id='genterWrapper']").$(byText("Female")).click();
        $("[id='userNumber']").setValue("89993339933");
        $("[id='uploadPicture']").uploadFromClasspath("textFile.txt");


        $("[id='submit']").click();


        $(".table-responsive").shouldNotBe(visible);
    }

    @Test
    public void phoneFieldShouldNotAcceptLettersTest() {
        $("[id='firstName']").setValue("Алёна");
        $("[id='lastName']").setValue("Иванова");
        $("[id='genterWrapper']").$(byText("Other")).click();
        $("[id='userNumber']").setValue("ggggggggggg");


        $("[id='submit']").click();


        $(".table-responsive").shouldNotBe(visible);
    }
}



