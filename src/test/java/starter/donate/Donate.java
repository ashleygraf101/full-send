package starter.donate;

import io.cucumber.java.ca.Donat;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Dropdown;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.findAll;

public class Donate {
    public static Performable byCustomAmount(String customAmount) {
        return Task.where(customAmount,
                Enter.theValue(customAmount).into(InputField.withNameOrId("input_amount_other_box")).thenHit(Keys.ENTER)
        );
    }

    public static Performable byState(String state) {
        return Task.where(state,
                SelectFromOptions.byVisibleText(state).from(DonationPage.STATE_SELECT)
        );
    }

    public static Performable byCountry(String country) {
        return Task.where(country,
                Click.on(By.id("country-change")),
                SelectFromOptions.byVisibleText(country).from(DonationPage.COUNTRY_SELECT),
                Click.on(Button.withText("Go"))
        );
    }

    public static Performable byPaymentMethod(String paymentMethod) {
        return Task.where(Click.on(Button.withCSSClass(paymentMethod)));
    };

    public static Performable withTransactionFee() {
        return Task.where(SetCheckbox.of("#ptf-checkbox").toTrue());
    };

    public static Performable monthly() {
        return Task.where(Click.on(By.xpath("//*[@id=\"actual-form\"]/fieldset[1]/ul/li[2]")));
    };

    public static Performable justOnce() {
        return Task.where(Click.on(By.xpath("//*[@id=\"actual-form\"]/fieldset[1]/ul/li[1]")));
    };
}
