package starter.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class LookForInformation {
    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(SearchForm.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }

    public static Performable fromLanguage(String language) {
        return Task.where("{0} searches for '" + language + "'",
                Enter.theValue(language)
                        .into(SearchArticle.ARTICLE_LANGUAGE_TEXT_SEARCH)
                        .thenHit(Keys.ENTER)
        );
    }


}
