package by.boiko.snet.dao.impl;


import by.boiko.snet.dao.EmailDao;
import by.boiko.snet.model.Email;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The class implements methods for access to MySQL database for Email.
 */
@Service
public class EmailDaoImpl implements EmailDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Email email) {
        sessionFactory.getCurrentSession().saveOrUpdate(email);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Email> loadAll() {
        return sessionFactory.getCurrentSession().createQuery("from Email").list();
    }

    @Override
    @Transactional
    public List<Email> loadNames() {
        return null;
    }
}
