package by.boiko.snet.dao.impl;


import by.boiko.snet.dao.UserDao;
import by.boiko.snet.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The class implements methods for access to MySQL database for User.
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> loadAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public User loadAllUsersForId(int id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional
    public void update(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    @Transactional
    public List<User> loadNames() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
}