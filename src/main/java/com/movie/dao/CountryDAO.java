package com.movie.dao;

import com.movie.entity.Country;

public class CountryDAO extends AbstractHibernateDao<Country> {
    public CountryDAO(){
        super(Country.class);
    }
}
