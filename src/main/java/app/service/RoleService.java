package app.service;

import app.model.Role;
import app.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements EntityService<Role> {

    @Autowired
    RoleDao dao;

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Role getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void update(Role role) {
        dao.update(role);
    }

    @Override
    public List<Role> getAll() {
        return dao.getAll();
    }
}
