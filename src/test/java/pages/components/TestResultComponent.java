package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestResultComponent {
    private SelenideElement resultTable = $(".modal-content");

    public void checkTable(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(Condition.text(value));

    }
}
