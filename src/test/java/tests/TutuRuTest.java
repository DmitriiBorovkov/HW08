package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;


public class TutuRuTest extends TestBase {
    @CsvSource(value = {
            "Москва , Париж",
            "Санкт-Петербург , Лондон"
    })
    @ParameterizedTest(name = "Проверка поиска авиабилетов {0} - {1}")
    void checkTicketSearchResult(String departureStation, String arrivalStation) {
        open("https://www.tutu.ru/");
        $("[placeholder='Откуда']").setValue(departureStation).parent().parent().$(".name_city").click();
        $("[placeholder='Куда']").setValue(arrivalStation).parent().parent().$(".name_city").click();
        $("[placeholder='Дата вылета']").click();
        $("[data-handler='today']").click();
        $(".b-button__arrow__button").click();

        $("[data-ti='searchPanel']").shouldHave(text(String.format("%s — %s", departureStation, arrivalStation)));
    }
}
