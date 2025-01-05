package starter.search;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class SearchArticle {
    public static final Target TITLE =  Target.the("article identifier").locatedBy("//*[@id=\"firstHeading\"]");
    public static Question<String> title() {
        return Text.of(TITLE);
    }

    public static final Target ARTICLE_LANGUAGE =  Target.the("article identifier").locatedBy("//*[@id=\"p-lang-btn\"]");
    public static Question<String> articleLanguageCount() {
        return Text.of(ARTICLE_LANGUAGE);
    }

    public static final Target ARTICLE_LANGUAGE_TEXT_SEARCH =  Target.the("article identifier").locatedBy("//*[@id=\"search\"]/div/div/input[2]");

    public static final Target LANGUAGES_LIST = Target.the(".uls-language-list")
            .located(By.cssSelector(".uls-language-list")).waitingForNoMoreThan(Duration.ofSeconds(20));
    public static Question<String> languagesList() {
        return Text.of(LANGUAGES_LIST);
    }
}
