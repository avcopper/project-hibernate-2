package com.movie.dao;

import com.movie.entity.Staff;

public class StaffDAO extends AbstractHibernateDao<Staff> {
    public StaffDAO(){
        super(Staff.class);
    }
}
