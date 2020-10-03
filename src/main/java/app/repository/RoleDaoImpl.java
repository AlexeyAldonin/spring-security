package app.repository;

import app.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    @Transactional
    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Transactional
    @Override
    public Role getById(Long id) {
        return entityManager.find(persistentClass, id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        entityManager
                .createQuery("DELETE FROM Role WHERE id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Transactional
    @Override
    public List<Role> getAll() {
        return entityManager
                .createQuery("SELECT r FROM Role r", Role.class)
                .getResultList();
    }
}
