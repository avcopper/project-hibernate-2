package com.movie.dao;

import com.movie.entity.Actor;

public class ActorDAO extends AbstractHibernateDao<Actor> {
    public ActorDAO(){
        super(Actor.class);
    }
}
