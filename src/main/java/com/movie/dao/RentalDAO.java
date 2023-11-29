package com.movie.dao;

import com.movie.entity.Rental;

public class RentalDAO extends AbstractHibernateDao<Rental> {
    public RentalDAO(){
        super(Rental.class);
    }
}
