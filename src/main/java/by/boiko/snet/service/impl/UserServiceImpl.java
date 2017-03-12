package by.boiko.snet.service.impl;


import by.boiko.snet.StringSplit;
import by.boiko.snet.dao.UserDao;
import by.boiko.snet.model.User;
import by.boiko.snet.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.JsonViewModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.monitorjbl.json.Match.match;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAll(int offset, int limit) {
        return userDao.loadAllWithOffsetAndLimit(offset, limit);
    }

    @Override
    @Transactional
    public User getAllForId(int id) {
        return userDao.loadAllUsersForId(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> getNames() {
        return userDao.loadNames();
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.loadAll();
    }

    @Override
    @Transactional
    public LocalDateTime getCreatedDate(int id) {
        return userDao.getCreatedDate(id);
    }

    @Override
    @Transactional
    public String getAllWithParams(int offset, int limit, String exc, String inc) throws JsonProcessingException {
        StringSplit stringSplit = new StringSplit();
        List<User> userList = userDao.loadAllWithOffsetAndLimit(offset, limit);
        ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
        if (offset != 0 && limit == 0 && exc == null && inc == null) {
            return mapper.writeValueAsString(JsonView.with(userList)
                    .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
        }
        if (offset == 0 && limit != 0 && exc == null && inc == null) {
            return mapper.writeValueAsString(JsonView.with(userList)
                    .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
        }
        if (offset == 0 && limit == 0 && exc != null && inc == null) {
            String[] str = stringSplit.stringSplit(exc);
            System.out.println(Arrays.toString(str));
            return mapper.writeValueAsString(JsonView.with(userList)
                    .onClass(User.class, match()
                            .exclude("*")
                            .include(str)));
        }
        if (offset == 0 && limit == 0 && exc == null && inc != null) {
            String[] str = stringSplit.stringSplit(inc);
            return mapper.writeValueAsString(JsonView.with(userList)
                    .onClass(User.class, match()
                            .exclude(str)));
        }if (offset != 0 && limit != 0 && exc == null && inc == null) {
            return mapper.writeValueAsString(JsonView.with(userList)
                    .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
        }
        return mapper.writeValueAsString(JsonView.with(userList)
                .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
    }
}