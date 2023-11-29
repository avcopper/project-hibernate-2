package com.movie.dao;

import com.movie.entity.Language;

public class LanguageDAO extends AbstractHibernateDao<Language> {
    public LanguageDAO(){
        super(Language.class);
    }
}
