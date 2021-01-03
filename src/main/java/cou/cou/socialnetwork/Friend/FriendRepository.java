package cou.cou.socialnetwork.Friend;

import cou.cou.socialnetwork.Friend.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Set;

@RepositoryRestResource(path="friend")
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    public Set<Friend> findFriendsByName(@PathVariable("name") String name);

    List<Friend> findAllByUserSenderIdOrUserReceiverId(int userSenderId, int userReceiverId);

}
