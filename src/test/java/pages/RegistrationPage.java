package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TestResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderWraper = $("#genterWrapper"),
            userPhoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            submitButton = $("#submit");




    CalendarComponent calendarComponent = new CalendarComponent();
    TestResultComponent testResultComponent = new TestResultComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage closeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWraper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserPhoneNumberInput(String number) {
        userPhoneNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setBirthday(String year, String month, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        testResultComponent.checkTable(key, value);
       return this;
    }
}



