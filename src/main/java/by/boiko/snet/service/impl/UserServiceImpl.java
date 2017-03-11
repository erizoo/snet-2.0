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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public String getAllWithParams(Integer offset, Integer limit, String exc, String inc, StringSplit stringSplit) throws JsonProcessingException {
        if (offset != null && limit == null && exc == null && inc == null) {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
            return mapper.writeValueAsString(JsonView.with(userDao.loadAllWithOffset(offset))
                    .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
        }
        if (offset == null && limit != null && exc == null && inc == null) {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
            return mapper.writeValueAsString(JsonView.with(userDao.loadAllWithLimit(limit))
                    .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
        }
        if (offset == null && limit == null && exc != null && inc == null) {
            String[] str = stringSplit.stringSplit(exc);
            List<String> result = new ArrayList();
            Collections.addAll(result, str);
            String[] strings = result.stream().toArray(String[]::new);
            System.out.println(Arrays.toString(strings));
            ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
            return mapper.writeValueAsString(JsonView.with(userDao.loadAllWithExc())
                    .onClass(User.class, match()
                            .exclude("*")
                            .include(strings)));
        }
        if (offset == null && limit == null && exc == null && inc != null) {
            String[] str = stringSplit.stringSplit(inc);
            List<String> result = new ArrayList();
            Collections.addAll(result, str);
            String[] strings = result.stream().toArray(String[]::new);
            ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
            return mapper.writeValueAsString(JsonView.with(userDao.loadAllWithInc())
                    .onClass(User.class, match()
                            .exclude(strings)));
        }if (offset != null && limit != null && exc == null && inc == null) {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
            return mapper.writeValueAsString(JsonView.with(userDao.loadAll(offset, limit))
                    .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
        }
        ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
        return mapper.writeValueAsString(JsonView.with(userDao.loadAll())
                .onClass(User.class, match().exclude("createdTimestamp", "modifiedTimestamp")));
    }
}