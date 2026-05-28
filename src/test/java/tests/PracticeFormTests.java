package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends BaseTest {


    @Test
    public void positiveRegistrationFormFillingTest() {
        open("https://demoqa.com/automation-practice-form");
        removeAds();


        $("[id='firstName']").setValue("Aleks");
        $("[id='lastName']").setValue("Pechkin");
        $("[id='userEmail']").setValue("Aleks@sdfs.com");
        $("[id='gender-radio-1']").click();
        $("[id='userNumber']").setValue("89999999977");

        $("[id='dateOfBirthInput']").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--001").click();

        $("[id='subjectsInput']").setValue("E")
                .pressEnter()
                .setValue("computer science")
                .pressEnter();

        $("[id='hobbies-checkbox-1']").click();
        $("[id='hobbies-checkbox-2']").click();
        $("[id='hobbies-checkbox-3']").click();

        File file = new File("C:/java/image.jpg");
        $("[id='uploadPicture']").uploadFile(file);

        $("[id='currentAddress']").setValue("Backer street, 221b");

        $("[id='react-select-3-input']").setValue("u").pressEnter();
        $("[id='react-select-4-input']").setValue("A").pressEnter();

        $("[id='submit']").click();



        $x("//tr[td[text()='Student Name']]/td[2]")
                .shouldHave(text("Aleks Pechkin"));

        $x("//tr[td[text()='Student Email']]/td[2]")
                .shouldHave(text("Aleks@sdfs.com"));

        $x("//tr[td[text()='Gender']]/td[2]")
                .shouldHave(text("Male"));

        $x("//tr[td[text()='Mobile']]/td[2]")
                .shouldHave(text("8999999997"));

        $x("//tr[td[text()='Date of Birth']]/td[2]")
                .shouldHave(text("01 July,1998"));

        $x("//tr[td[text()='Subjects']]/td[2]")
                .shouldHave(text("English, Computer Science"));

        $x("//tr[td[text()='Hobbies']]/td[2]")
                .shouldHave(text("Sports, Reading, Music"));

        $x("//tr[td[text()='Picture']]/td[2]")
                .shouldHave(text("image.jpg"));

        $x("//tr[td[text()='Address']]/td[2]")
                .shouldHave(text("Backer street, 221b"));

        $x("//tr[td[text()='State and City']]/td[2]")
                .shouldHave(text("Uttar Pradesh Agra"));
    }
}
