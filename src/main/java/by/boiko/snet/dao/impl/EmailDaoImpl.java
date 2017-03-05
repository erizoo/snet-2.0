package by.boiko.snet.dao.impl;


import by.boiko.snet.dao.EmailDao;
import by.boiko.snet.model.Email;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        sessionFactory.getCurrentSession().save(email);
    }
}
