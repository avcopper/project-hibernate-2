package com.movie.dao;

import com.movie.entity.Category;

public class CategoryDAO extends AbstractHibernateDao<Category> {
    public CategoryDAO(){
        super(Category.class);
    }
}
