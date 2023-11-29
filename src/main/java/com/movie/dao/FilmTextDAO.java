package com.movie.dao;

import com.movie.entity.FilmText;

public class FilmTextDAO extends AbstractHibernateDao<FilmText> {
    public FilmTextDAO(){
        super(FilmText.class);
    }
}
