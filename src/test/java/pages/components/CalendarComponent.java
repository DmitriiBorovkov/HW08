package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private String dayOfMonth = ".react-datepicker__day--0";

    public void setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").$(byText(month)).click();
        dayOfMonth += day;
        $(dayOfMonth).click();
    }
}
