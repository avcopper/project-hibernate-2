package com.movie.dao;

import com.movie.entity.City;

public class CityDAO extends AbstractHibernateDao<City> {
    public CityDAO(){
        super(City.class);
    }
}
