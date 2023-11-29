package com.movie.dao;

import com.movie.entity.Customer;

public class CustomerDAO extends AbstractHibernateDao<Customer> {
    public CustomerDAO (){
        super(Customer.class);
    }
}
