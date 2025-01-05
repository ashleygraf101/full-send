package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import starter.donate.DonationPage;
import starter.navigation.NavigateTo;
import starter.search.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.donate.DonationPage.ARTICLE_LANGUAGES_MANUAL_COUNT;

public class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @When("{actor} starts to look up {string}")
    public void startSearchFor(Actor actor, String term) {
        actor.attemptsTo(
                StartLookForInformation.about(term)
        );
    }

    @When("{actor} selects article option {string}")
    public void choosesSearchOption(Actor actor, String option) {
                actor.attemptsTo(
                        SelectFromSuggestionDropdown.withText(option)
                );
    }

    @When("{actor} selects article language {string}")
    public void choosesArticleLanguage(Actor actor, String language) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(language).from(By.id("searchLanguage"))
        );
    }

    @When("{actor} selects language {string}")
    public void selectsLanguage(Actor actor, String language) {
        actor.attemptsTo(
                SelectFromFeaturedLanguageList.withText(language)
        );
    }

    @When("{actor} selects article language {string} from article")
    public void selectsArticleLanguage(Actor actor, String language) {
        actor.attemptsTo(
                Click.on(SearchArticle.ARTICLE_LANGUAGE),
                SelectFromArticleLanguageList.withText(language)
        );
    }

    @When("{actor} searches for article language {string} from article and selects {string}")
    public void searchesForArticleLanguage(Actor actor, String languageSearched, String languageSelected) {
        actor.attemptsTo(
                Click.on(SearchArticle.ARTICLE_LANGUAGE),
                LookForInformation.fromLanguage(languageSearched),
                SelectFromArticleLanguageList.withText(languageSelected)
        );
    }



    @Then("{actor} sees the article title contains the {string}")
    public void viewContentTitle(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(SearchArticle.title()).contains(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term)
        );
    }

    @Then("{actor} should see donate link as {string}")
    public void heShouldSeeDonateLinkAsDonate(Actor actor, String donate) {
        actor.attemptsTo(
                Ensure.that(SearchForm.donateLink()).contains(donate)
        );
    }

    @Then("{actor} should not see {string} in the article language list")
    public void shouldNotSeeLanguageInTheArticleLanguageList(Actor actor, String language) {
        actor.attemptsTo(
                Click.on(SearchArticle.ARTICLE_LANGUAGE),
                WaitUntil.the(SearchArticle.LANGUAGES_LIST, isVisible()),
                Ensure.that(SearchArticle.languagesList()).doesNotContain(language)
        );
    }

    @Then("{actor} sees the language count for the article is {string}")
    public void seeArticleLanguageCount(Actor actor, String count) {
        actor.attemptsTo(


                Click.on(SearchArticle.ARTICLE_LANGUAGE),
                Ensure.that(SearchArticle.articleLanguageCount()).isEqualTo(DonationPage.ARTICLE_LANGUAGES_MANUAL_COUNT + " languages")
        );
    }

}
