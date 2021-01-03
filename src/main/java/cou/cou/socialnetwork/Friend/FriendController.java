package cou.cou.socialnetwork.Friend;

import cou.cou.socialnetwork.Friend.Friend;
import cou.cou.socialnetwork.Friend.FriendRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="friend")
public class FriendController {
    @Autowired
    private FriendRepository FriendRepository;

    @GetMapping
    public Iterable<Friend> getFriends()
    {
        return FriendRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Friend> getFriend(@PathVariable("id") int id)
    {
        return FriendRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Friend> findFriendsByName(@PathVariable("name") String name)
    {
        return FriendRepository.findFriendsByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteThisFriend(@PathVariable int id) throws ResourceNotFoundException {
        Friend i = FriendRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        FriendRepository.delete(i);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public void createFriend(@RequestBody Friend newFriend) {
        if (!FriendRepository.existsById(newFriend.getId())) {
            FriendRepository.save(newFriend);
        }
    }
}