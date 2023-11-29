package com.movie.dao;

import com.movie.entity.Film;

public class FilmDAO extends AbstractHibernateDao<Film> {
    public FilmDAO(){
        super(Film.class);
    }
}
