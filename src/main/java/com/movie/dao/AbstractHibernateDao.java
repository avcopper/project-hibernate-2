package com.movie.dao;

import java.util.List;
import org.hibernate.Session;
import jakarta.persistence.Query;
import org.hibernate.Transaction;
import javax.annotation.PreDestroy;
import org.hibernate.SessionFactory;
import com.movie.repository.MovieRepositoryDb;

public abstract class AbstractHibernateDao<T> {
    private final Class<T> clazz;
    private final SessionFactory sessionFactory;

    public AbstractHibernateDao(final Class<T> clazzToSet)   {
        this.clazz = clazzToSet;
        sessionFactory = MovieRepositoryDb.getSessionFactory();
    }

    /**
     * Возвращает объект по его id
     * @param id - id объекта
     * @return
     */
    public T getById(final long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    /**
     * Возвращает список объектов в диапазоне
     * @param from - начальный элемент
     * @param count - количество элементов
     * @return
     */
    public List<T> getItems(int from, int count) {
        Query query = getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(from);
        query.setMaxResults(count);
        return query.getResultList();
    }

    /**
     * Возвращает весь список элементов
     * @return
     */
    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName(), clazz).list();
    }

    /**
     * Сохранеят объект в базу
     * @param entity - объект
     * @return
     */
    public T create(final T entity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        session.flush();
        transaction.commit();
        return entity;
    }

    /**
     * Обновляет объект в базе
     * @param entity - объект
     * @return
     */
    public T update(final T entity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        session.flush();
        transaction.commit();
        return entity;
    }

    /**
     * Удаляет объект из базы
     * @param entity - объект
     */
    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    /**
     * Удаляет объект из базы по его id
     * @param entityId - id объекта
     */
    public void deleteById(final long entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    /**
     * Возвращает сессию
     * @return
     */
    protected Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @PreDestroy
    public void beforeStop() {
        sessionFactory.close();
    }
}
