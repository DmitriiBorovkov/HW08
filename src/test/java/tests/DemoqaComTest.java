package tests;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegistrationPage;


public class DemoqaComTest extends TestBase {
    @CsvFileSource(resources = "/testData/DemoqaComTestData.csv")
    @ParameterizedTest(name = "Проверка заполнения формы регистрации с минимальными данными для {2}")
    void fillFormWithMinimumData(String name, String lastName, String gender, String phoneNumber, String year, String month, String day) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .closeBanner()
                .setName(name)
                .setLastName(lastName)
                .setGender(gender)
                .setUserPhoneNumberInput(phoneNumber)
                .setBirthday(year, month, day)
                .submitForm()

                .checkResult("Student Name", String.format("%s %s", name, lastName))
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", String.format("%s %s,%s", day, month, year));

    }
}
