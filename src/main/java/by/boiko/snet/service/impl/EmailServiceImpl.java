package by.boiko.snet.service.impl;


import by.boiko.snet.dao.EmailDao;
import by.boiko.snet.model.Email;
import by.boiko.snet.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public void saveEmails(Email email) {
        emailDao.save(email);
    }

    @Override
    public List<Email> getAll() {
        return emailDao.loadAll();
    }

    @Override
    public List<Email> getNames() {
        return emailDao.loadNames();
    }
}
