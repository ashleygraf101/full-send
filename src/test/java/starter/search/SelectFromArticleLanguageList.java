package starter.search;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static starter.search.SearchArticle.LANGUAGES_LIST;

public class SelectFromArticleLanguageList implements Task {

    private final String language;

    private SelectFromArticleLanguageList(String language) {
        this.language = language;
    }

    public static SelectFromArticleLanguageList withText(String text) {
        return new SelectFromArticleLanguageList(text);
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

