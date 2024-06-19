package tests;

import data.DayOfWeek;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiWebTest {

    static Stream<Arguments> getDayOfWeek() {
        return Stream.of(
                Arguments.of(
                        DayOfWeek.SUNDAY.description
                ),
                Arguments.of(
                        DayOfWeek.MONDAY.description
                )
        );
    }

    @MethodSource("getDayOfWeek")
    @ParameterizedTest(name = "Проверка поиска статьи про {0} на wiki")
    void chekDayOfWeek(String day) {
        open("https://ru.wikipedia.org/");
        $("[placeholder='Искать в Википедии']").setValue(day);
        $("#searchButton").click();
        $("#firstHeading").shouldHave(text(day));
    }
}



