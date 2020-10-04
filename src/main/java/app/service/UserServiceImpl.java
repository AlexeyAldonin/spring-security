package app.service;

import app.model.Role;
import app.model.User;
import app.repository.RoleDao;
import app.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public UserServiceImpl() {
    }

    @Transactional
    @PostConstruct
    public void init(){
        Role[] roles = {new Role("ADMIN"), new Role("USER")};
        Set<Role> allRoles = new HashSet<>(Arrays.asList(roles));
        //allRoles.forEach(roleDao::save);
        User admin = new User("test", "test");
        admin.setRoles(allRoles);
        userDao.save(admin);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
