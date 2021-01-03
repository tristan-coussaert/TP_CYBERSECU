package cou.cou.socialnetwork.Role;

import cou.cou.socialnetwork.Role.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role getRoleByName(String name);
}