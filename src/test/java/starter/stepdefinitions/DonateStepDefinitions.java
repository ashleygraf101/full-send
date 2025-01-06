package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import starter.navigation.NavigateTo;
import starter.donate.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DonateStepDefinitions {

    @Given("{actor} is deciding to donate to Wikipedia")
    public void donatingThings(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theDonationPage()
        );
    }

    @When("{actor} accepts promotional emails")
    public void acceptsPromotionalEmails(Actor actor) {
        actor.attemptsTo(
                Donate.acceptPromotionalEmails()
        );
    }

    @When("{actor} chooses to use {string} bank accounts")
    public void selectDonationBankAccount(Actor actor, String country) {
        actor.attemptsTo(
                Donate.byCountry(country)
        );
    }

    @When("{actor} chooses to donate a custom {string}")
    public void ChoosesToDonateAmount(Actor actor, String amount) {
        actor.attemptsTo(
                WaitUntil.the(DonationPage.CUSTOM_INPUT_BOX, isVisible()),
                Donate.byCustomAmount(amount)
        );
    }


    @When("{actor} chooses to donate by {string}")
    public void choosesToDonateBy(Actor actor, String paymentMethod) {
        actor.attemptsTo(
                Donate.byPaymentMethod(paymentMethod)
        );
    }

    @When("{actor} chooses to donate monthly")
    public void choosesToDonateMonthly(Actor actor) {
        actor.attemptsTo(
                Donate.monthly()
        );
    }

    @When("{actor} chooses to donate just once")
    public void choosesToDonateJustOnce(Actor actor) {
        actor.attemptsTo(
                Donate.justOnce()
        );
    }


    @When("{actor} chooses to use {string} as a state")
    public void choosesState(Actor actor, String state) {
        actor.attemptsTo(
                Donate.byState(state)
        );
    }

    @When("{actor} chooses to donate the transaction fee")
    public void choosesToDonateTheTransactionFee(Actor actor) {
        actor.attemptsTo(
                Donate.withTransactionFee()
        );

    }

    @When("{actor} chooses to donate a set {string}")
    public void heChoosesToDonateASetAmount(Actor actor, String amount) {
        actor.attemptsTo(
                JavaScriptClick.on(By.id("input_amount_" + amount))
        );
    }

    @Then("{actor} should see relevant details for {string}")
    public void seesState(Actor actor, String state) {
        actor.attemptsTo(
                Ensure.that(DonationPage.selectedState()).isEqualTo(state)
        );
    }

    @Then("{actor} should see relevant details for donating monthly")
    public void shouldSeeRelevantDetailsForDonatingMonthly(Actor actor) {
        actor.attemptsTo(
                Ensure.that(DonationPage.donationAmountTitle()).contains("Monthly donation amount\n$2.00")
        );
    }

    @Then("{actor} should see relevant details for donating just once")
    public void shouldSeeRelevantDetailsForDonatingJustOnce(Actor actor) {
        actor.attemptsTo(
                Ensure.that(DonationPage.donationAmountTitle()).contains( "Donation amount\n$2.00")
        );
    }

    @Then("{actor} should see relevant details for {string}, {string}, {string}")
    public void viewCurrencyChanges(Actor actor, String country, String currency, String currencySymbol) {
        actor.attemptsTo(
                Ensure.that(DonationPage.selectedCountry()).contains(country),
                Ensure.that(DonationPage.selectedCurrency()).contains("Donation amount (" + currency + ")"),
                Ensure.that(DonationPage.selectedCurrencySymbol()).contains(currencySymbol)
        );
    }

    @Then("{actor} sees the charge with {string}")
    public void seesTheChargeWithFee(Actor actor, String fullPrice) {
        actor.attemptsTo(
                Ensure.that(DonationPage.selectedAmount()).contains(fullPrice)
        );
    }

    @Then("{actor} sees the {string}")
    public void seesTheChargeWithFeeAmount(Actor actor, String fee) {
        actor.attemptsTo(
                WaitUntil.the(DonationPage.TRANSACTION_FREE_CHECKBOX, isVisible()),
                Ensure.that(DonationPage.transactionFreeCheckbox()).contains(fee)
        );
    }

    @Then("{actor} sees the {string} charge without fee")
    public void seesTheChargeWithoutFee(Actor actor, String amount) {
        actor.attemptsTo(
                Ensure.that(DonationPage.selectedAmount()).contains(amount)
        );
    }

    @Then("{actor} sees the selected amount is {string}")
    public void seesTheExpectedAmount(Actor actor, String output) {
        actor.attemptsTo(
                Ensure.that(DonationPage.selectedAmount()).contains(output)
        );
    }

    @Then("{actor} should see a lower limit error message {string}")
    public void shouldSeeALowerLimitErrorMessage(Actor actor, String error) {
        actor.attemptsTo(
                Ensure.that(DonationPage.lowerLimitError()).contains(error)
        );
    }

    @Then("{actor} should see an upper limit error message {string}")
    public void shouldSeeAnUpperLimitErrorMessage(Actor actor, String error) {
        actor.attemptsTo(
                Ensure.that(DonationPage.upperLimitError()).contains(error)
        );
    }

}
