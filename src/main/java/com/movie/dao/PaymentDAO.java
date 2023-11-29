package com.movie.dao;

import com.movie.entity.Payment;

public class PaymentDAO extends AbstractHibernateDao<Payment> {
    public PaymentDAO(){
        super(Payment.class);
    }
}
