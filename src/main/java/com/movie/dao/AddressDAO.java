package com.movie.dao;

import com.movie.entity.Address;

public class AddressDAO extends AbstractHibernateDao<Address> {
    public AddressDAO(){
        super(Address.class);
    }
}
