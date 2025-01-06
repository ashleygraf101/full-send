package starter.donate;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.SelectedVisibleTextValue;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.findAll;

public class DonationPage {

    public static Target STATE_SELECT = Target.the("state name").locatedBy("//*[@id=\"state_province\"]").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static Target COUNTRY_SELECT = Target.the("country select").locatedBy("//*[@id=\"country-select\"]").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static Target TRANSACTION_FREE_CHECKBOX = Target.the("error message").locatedBy("//*[@id=\"actual-form\"]/fieldset[2]/div[3]/div/label/span").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static Target AMOUNT_SELECTED = Target.the("set amount selected").locatedBy("//*[@id=\"selected-amount\"]").waitingForNoMoreThan(Duration.ofSeconds(10));
    public static Question<String> selectedAmount() {
        return Text.of(AMOUNT_SELECTED);
    }

    public static Question<String> transactionFreeCheckbox() {
        return Text.of(TRANSACTION_FREE_CHECKBOX);
    }

    public static Question<String> lowerLimitError() {
        return Text.of(By.cssSelector("#actual-form > fieldset.amount-options.lp-haserror > div.lp-error.lp-error-smallamount"));
    }
    public static Question<String> upperLimitError() {
        return Text.of(By.cssSelector("#actual-form > fieldset.amount-options.lp-haserror > div.lp-error.lp-error-bigamount"));
    }
    public static Target SELECTED_COUNTRY = Target.the("error message").locatedBy("//*[@id=\"country-confirm-name\"]").waitingForNoMoreThan(Duration.ofSeconds(10));

    public static Question<String> selectedCountry() {
        return Text.of(SELECTED_COUNTRY);
    }

    public static Question<String> selectedCurrency() {
        return Text.of(By.id("radiobuttons-table-header"));
    }
    public static Question<String> selectedCurrencySymbol() {
        return Text.of(By.xpath("//*[@id=\"actual-form\"]/fieldset[2]/ul/li[1]/label"));
    }
    public static Question<String> donationAmountTitle() {
        return Text.of(By.xpath("//*[@id=\"step1header\"]/h3"));
    }
    public static Question<String> selectedState() {
        return SelectedVisibleTextValue.of("#state_province");
    }
    public static Target CUSTOM_INPUT_BOX = Target.the("custom").locatedBy("//*[@id=\"input_amount_other_box\"]");
    public static Target ARTICLE_LANGUAGES_MANUAL_COUNT = Target.the("custom").locatedBy("//*[@class=\"uls-lcd-region-section\"]/li\"]");
    public static Question<String> articleLanguagesManualCount() {
        return
                Text.of(ARTICLE_LANGUAGES_MANUAL_COUNT);
    }
}
