import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class TestDragDrop {
    @BeforeEach
    void setupConfig() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    void droppingWithActionTest() {
        open("/drag_and_drop");
        SelenideElement leftSquare = $("#column-a").shouldHave(text("A"));
        SelenideElement rightSquare = $("#column-b").shouldHave(text("B"));
        actions().clickAndHold(leftSquare).moveToElement(rightSquare).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void droppingWithDragAndDropTest() {
        open("/drag_and_drop");
        SelenideElement leftSquare = $("#column-a").shouldHave(text("A"));
        SelenideElement rightSquare = $("#column-b").shouldHave(text("B"));
        leftSquare.dragAndDrop(to(rightSquare));
        leftSquare.shouldHave(text("B"));
        rightSquare.shouldHave(text("A"));
    }
}
