package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Environment.yandexMarketItemName;

@Epic("QA.GURU automation course")
@Story("Yandex tests")
@Tag("yandex")
class YandexMarket_Tests extends TestBase {

    @Test
    @Description("Checking item can be found")
    void checkItemCanBeFound() {
        open("http://market.yandex.ru");

        $("html").shouldHave(text("Яндекс.Маркет"));
        $("#header-search").val(yandexMarketItemName).pressEnter();
        $x("//h3/a[1]").click();
        switchTo().window(1);

        $("html").shouldHave(text(yandexMarketItemName));
    }
}

