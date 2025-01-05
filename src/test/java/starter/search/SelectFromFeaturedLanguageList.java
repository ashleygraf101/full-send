package starter.search;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class SelectFromFeaturedLanguageList implements Task {

    private final String language;

    // Targets for the dropdown elements
    private static final Target LANGUAGES_LIST = Target.the("central-featured")
            .located(By.cssSelector(".central-featured")).waitingForNoMoreThan(Duration.ofSeconds(20));

    private SelectFromFeaturedLanguageList(String language) {
        this.language = language;
    }

    public static SelectFromFeaturedLanguageList withText(String text) {
        return new SelectFromFeaturedLanguageList(text);
    }

    @Override
    @Step("{0} selects suggestion with text '#language'")
    public <T extends Actor> void performAs(T actor) {
        // Find and click the suggestion link containing the desired text
        WebElementFacade selectLanguage = LANGUAGES_LIST.resolveFor(actor)
                .findBy(String.format(".//a[contains(.,'%s')]", language));

        selectLanguage.click();
    }
}

