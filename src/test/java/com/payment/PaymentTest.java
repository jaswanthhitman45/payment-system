package com.payment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class PaymentTest {

    PaymentApp app = new PaymentApp();

    @Test
    @DisplayName("Test Successful Payment Validation")
    void testValidPayment() {
        // Test case: Success (Amount within valid range)
        assertTrue(app.validatePayment(500.00), "Payment of 500 should be valid.");
    }

    @Test
    @DisplayName("Test Failed Payment - Negative Amount")
    void testNegativePayment() {
        // Test case: Failure (Amount is negative)
        assertFalse(app.validatePayment(-50.0), "Negative payments must fail.");
    }

    @Test
    @DisplayName("Test Failed Payment - Excessive Amount")
    void testExcessivePayment() {
        // Test case: Failure (Amount exceeds security limit)
        assertFalse(app.validatePayment(100000.0), "Over-limit payments must fail for security.");
    }

    @Test
    @DisplayName("Test Currency Support Success")
    void testSupportedCurrency() {
        assertTrue(app.isCurrencySupported("USD"));
    }
}