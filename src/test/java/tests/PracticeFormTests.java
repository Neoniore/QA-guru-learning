package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends BaseTest {


    @Test
    public void firesTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);


        $("[id='firstName']").setValue("Aleks");
        $("[id='lastName']").setValue("Pechkin");
        $("[id='userEmail']").setValue("Aleks@sdfs.com");
        $("[id='gender-radio-1']").click();

        $("[id='dateOfBirthInput']").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--001").click();


        $("[id='userNumber']").setValue("89999999977");
        System.out.println("dsfsdf");

    }
}
