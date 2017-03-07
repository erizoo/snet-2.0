package by.boiko.snet.service.impl;


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
    public List<User> getAllWithOffset(Integer offset) {
        return userDao.loadAllWithOffset(offset);
    }

    @Override
    public List<User> getAllWithLimit(Integer limit) {
        return userDao.loadAllWithLimit(limit);
    }

    @Override
    public List<User> getAllWithInc(String s) {
        return userDao.loadAllWithInc(s);
    }
}