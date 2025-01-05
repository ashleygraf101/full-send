package starter.enums;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public enum DonationTestData {
    TEN("10", "$0.40"),
    ELEVEN("11", "$0.44"),
    TWELVE("12", "$0.48"),
    THIRTEEN("13", "$0.52"),
    FOURTEEN("14", "$0.56"),
    FIFTEEN("15", "$0.60"),
    SIXTEEN("16", "$0.64"),
    SEVENTEEN("17", "$0.68"),
    EIGHTEEN("18", "$0.72"),
    NINETEEN("19", "$0.76"),
    TWENTY("20", "$0.80");

    public final String amount;
    public final String expectedFee;

    DonationTestData(String amount, String expectedFee) {
        this.amount = amount;
        this.expectedFee = expectedFee;
    }
}

