package app.repository;

import app.model.Role;

import java.util.List;

public interface RoleDao extends Dao<Role> {
    @Override
    void save(Role role);

    @Override
    List<Role> getAll();
}
