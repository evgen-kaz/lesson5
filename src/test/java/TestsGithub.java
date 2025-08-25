import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestsGithub {

    @BeforeEach
    void setupConfig() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";
    }

    @Test
    void testsGithub() {
        String textOnPageEnterprises = """
                The AI-powered
                developer platform
                To build, scale, and deliver secure software.
                """;

        open(baseUrl);
        $(".HeaderMenu-wrapper").$(withTagAndText("button", "Solutions")).hover();
        $(withTagAndText("a", "Enterprises")).click();
        $("div").shouldHave(text(textOnPageEnterprises));
    }
}