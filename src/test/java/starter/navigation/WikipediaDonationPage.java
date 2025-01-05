package starter.navigation;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.findAll;

@DefaultUrl("https://donate.wikimedia.org/w/index.php?title=Special:LandingPage&country=AU&uselang=en&wmf_medium=sidebar&wmf_source=donate&wmf_campaign=en.wikipedia.org")
public class WikipediaDonationPage extends PageObject {
}

