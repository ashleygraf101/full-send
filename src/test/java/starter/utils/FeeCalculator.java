package starter.utils;

public class FeeCalculator {
    public static String calculateExpectedFee(String amount) {
        int inputValue = Integer.parseInt(amount);
        double fee = inputValue * 0.04;
        return String.format("$%.2f", fee);
    }
}
