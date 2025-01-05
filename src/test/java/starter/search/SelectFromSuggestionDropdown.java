package starter.search;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class SelectFromSuggestionDropdown implements Task {

    private final String suggestionText;

    // Targets for the dropdown elements
    private static final Target SUGGESTIONS_DROPDOWN = Target.the("suggestions dropdown")
            .located(By.cssSelector(".suggestions-dropdown")).waitingForNoMoreThan(Duration.ofSeconds(20));

    private static final Target SUGGESTION_LINK = Target.the("suggestion link")
            .located(By.cssSelector(".suggestion-link"));

    private SelectFromSuggestionDropdown(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public static SelectFromSuggestionDropdown withText(String text) {
        return new SelectFromSuggestionDropdown(text);
    }

    @Override
    @Step("{0} selects suggestion with text '#suggestionText'")
    public <T extends Actor> void performAs(T actor) {
        // Find and click the suggestion link containing the desired text
        WebElementFacade suggestion = SUGGESTIONS_DROPDOWN.resolveFor(actor)
                .findBy(String.format(".//a[contains(.,'%s')]", suggestionText));

        suggestion.click();
    }
}

