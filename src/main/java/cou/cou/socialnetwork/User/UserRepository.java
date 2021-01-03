package cou.cou.socialnetwork.User;


import cou.cou.socialnetwork.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Set;

@RepositoryRestResource(path="user")
public interface UserRepository extends JpaRepository<User, Integer> {

    public Set<User> findUsersByEmail(@PathVariable("email") String email);

}