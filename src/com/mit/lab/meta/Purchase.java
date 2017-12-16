package com.mit.lab.meta;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.meta.Purchase</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 11/28/2017
 */
public class Purchase {
    private Donut _donut;
    private Payment _payment;

    public Purchase(Donut donut, Payment payment) {
        _donut = donut;
        _payment = payment;
    }
}
