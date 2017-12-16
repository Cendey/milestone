package com.mit.lab.norm;

import com.mit.lab.meta.CreditCard;
import com.mit.lab.meta.Donut;
import com.mit.lab.meta.Payment;
import com.mit.lab.meta.Tuple;

import java.util.Collections;
import java.util.List;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.norm.DonutShop</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 11/28/2017
 */
public class DonutShop {

    public static Tuple<Donut, Payment> buyDonut(CreditCard creditCard) {
        Donut donut = new Donut();
        Payment payment = new Payment(creditCard, donut.calculate());
        return new Tuple<>(donut, payment);
    }

    public static Tuple<List<Donut>, Payment> buyDonuts(final int quantity, final CreditCard creditCard) {
        return new Tuple<>(Collections.nCopies(quantity, new Donut(quantity)), new Payment(creditCard, quantity));
    }

}
