package com.movie.dao;

import com.movie.entity.Store;

public class StoreDAO extends AbstractHibernateDao<Store> {
    public StoreDAO(){
        super(Store.class);
    }
}
