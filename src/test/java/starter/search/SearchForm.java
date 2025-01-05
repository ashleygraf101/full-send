package starter.search;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class SearchForm {
    static Target SEARCH_FIELD = Target.the("search").locatedBy("//*[@id=\"searchInput\"]");

    private static final Target DONATE_LINK = Target.the("donate link")
            .locatedBy("//*[@id=\"pt-sitesupport-2\"]").waitingForNoMoreThan(Duration.ofSeconds(5));

    public static Question<String> donateLink() {
        return Text.of(DONATE_LINK);
    }
}

