package com.tomas.ile.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 13/08/2016
 */
@Repository
public class ImplementDao extends HibernateTemplate implements DAO
{
    @Inject
    public ImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }
    /**
     * Execute the action specified by the given action object within a
     * {@link Session}.
     * <p>Application exceptions thrown by the action object get propagated
     * to the caller (can only be unchecked). Hibernate exceptions are
     * transformed into appropriate DAO ones. Allows for returning a result
     * object, that is a domain object or a collection of domain objects.
     * <p>Note: Callback code is not supposed to handle transactions itself!
     * Use an appropriate transaction manager like
     * {@link HibernateTransactionManager}. Generally, callback code must not
     * touch any {@code Session} lifecycle methods, like close,
     * disconnect, or reconnect, to let the template do its work.
     *
     * @param action callback object that specifies the Hibernate action
     * @return a result object returned by the action, or {@code null}
     * @throws DataAccessException in case of Hibernate errors
     * @see HibernateTransactionManager
     * @see Session
     */
    @Override
    public <T> T execute(HibernateCallback<T> action) throws DataAccessException
    {
        return null;
    }
}
