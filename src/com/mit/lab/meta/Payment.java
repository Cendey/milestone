package com.mit.lab.meta;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.meta.Payment</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 11/28/2017
 */
public class Payment {

    private final CreditCard creditCard;
    private final double amount;

    public Payment(CreditCard creditCard, double amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public double getAmount() {
        return amount;
    }

    public Payment combine(Payment payment) {
        if (creditCard.equals(payment.getCreditCard())) {
            return new Payment(creditCard, amount + payment.getAmount());
        } else {
            throw new IllegalStateException("Cards don't match.");
        }
    }
}
