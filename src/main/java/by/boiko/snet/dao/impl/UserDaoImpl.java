package by.boiko.snet.dao.impl;


import by.boiko.snet.dao.UserDao;
import by.boiko.snet.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The class implements methods for access to MySQL database for User.
 */
@SuppressWarnings("unchecked")
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> loadAll(int offset, int limit) {
        return sessionFactory.getCurrentSession().createQuery("from User u").setFirstResult(offset).setMaxResults(limit).list();
    }

    @Override
    public void delete(int id) {
        User user = sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User loadAllUsersForId(int id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public List<User> loadAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }


    @Override
    @Transactional
    public LocalDateTime getCreatedDate(int id) {
        return (LocalDateTime) sessionFactory.getCurrentSession().createQuery("select u.createdTimestamp from User u where id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional
    public List<User> loadAllWithOffset(Integer offset) {
        return sessionFactory.getCurrentSession().createQuery("from User u").setFirstResult(offset).list();
    }

    @Override
    @Transactional
    public List<User> loadAllWithLimit(Integer limit) {
        return sessionFactory.getCurrentSession().createQuery("from User u").setMaxResults(limit).list();
    }

}