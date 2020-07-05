package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Environment.yandexMarketItemName;
import static io.qameta.allure.Allure.step;

@Epic("QA.GURU automation course")
@Story("Yandex tests")
@Tag("yandex")
class YandexMarket_Tests extends TestBase {

    @Test
    @Description("Checking item can be found")
    void checkItemCanBeFound() {
        step("Заходим на Яндекс Маркет", () -> {
            open("http://market.yandex.ru");
        });
        step("Проверяем наличие текста Яндекс.Маркет", () -> {
            $("html").shouldHave(text("Яндекс.Маркет"));
        });
        step("Передаем название запрашиваемого товара из Environment и переходим к результатам поиска", () -> {
            $("#header-search").val(yandexMarketItemName).pressEnter();
            $x("//h3/a[1]").click();
            switchTo().window(1);
        });
        step("Проверяем наличие переданного текста в результатах поиска", () -> {
            $("html").shouldHave(text(yandexMarketItemName));
        });
    }
}

