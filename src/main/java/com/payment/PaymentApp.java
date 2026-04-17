package com.payment;

public class PaymentApp {

    public static void main(String[] args) {
        System.out.println("--- Payment Processing System Starting ---");
    }

    /**
     * Task 1: Develop payment validation logic
     * Validates that payment is above zero and does not exceed a safety limit.
     */
    public boolean validatePayment(double amount) {
        // Logic: Payment must be positive and less than 10,000 for security
        if (amount <= 0 || amount > 10000) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the currency code is supported.
     */
    public boolean isCurrencySupported(String currency) {
        return "USD".equalsIgnoreCase(currency) || "EUR".equalsIgnoreCase(currency);
    }
}