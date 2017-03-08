package by.boiko.snet.service.impl;


import by.boiko.snet.StringSplit;
import by.boiko.snet.dao.UserDao;
import by.boiko.snet.model.User;
import by.boiko.snet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll(int offset, int limit) {
        return userDao.loadAll(offset, limit);
    }

    @Override
    public User getAllForId(int id) {
        return userDao.loadAllUsersForId(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> getNames() {
        return userDao.loadNames();
    }

    @Override
    public List<User> getAll() {
        return userDao.loadAll();
    }

    @Override
    public LocalDateTime getCreatedDate(int id) {
        return userDao.getCreatedDate(id);
    }

    @Override
    public List<User> getAllWithParams(Integer offset, Integer limit, String exc, String inc, StringSplit stringSplit) {
        if (offset != null && limit == null && exc == null && inc == null) {
            return userDao.loadAllWithOffset(offset);
        }
        if (offset == null && limit != null && exc == null && inc == null) {
            return userDao.loadAllWithLimit(limit);
        }
        if (offset == null && limit == null && exc != null && inc == null) {
            StringBuilder builder = new StringBuilder();
            StringBuilder builder1 = new StringBuilder();
            String us = "u.";
            String str = stringSplit.stringSplit(exc);
            String b = str.replaceAll(" ", "");
            ;
            builder1.append(b);
            String s = builder1.substring(1, builder1.length() - 1);
            for (String constraint : s.split(",")) {
                builder.append(us);
                builder.append(constraint += ", ");
            }
            String s3 = builder.substring(0, builder.length() - 2);
            return userDao.loadAllWithExc(s3);
        }
        if (offset == null && limit == null && exc == null && inc != null) {
            StringBuilder builder = new StringBuilder();
            String us = "u.";
            for (String constraint : inc.split(",")) {
                builder.append(us);
                builder.append(constraint += ",");
            }
            String s = builder.substring(0, builder.length() - 1);
            return userDao.loadAllWithInc(s);
        }if (offset != null && limit != null && exc == null && inc == null) {
          return userDao.loadAll(offset, limit);
        }
        return userDao.loadAll();
    }
}