package cou.cou.socialnetwork.User;

import cou.cou.socialnetwork.User.User;
import cou.cou.socialnetwork.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository UserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserRepository.save(user);
    }

    @GetMapping
    public Iterable<User> getUsers()
    {
        return UserRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> GetThisUser(@PathVariable int id) throws ResourceNotFoundException {
        User i = UserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return ResponseEntity.ok().body(i);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteThisUser(@PathVariable int id) throws ResourceNotFoundException {
        User i = UserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        UserRepository.delete(i);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{email}")
    public Set<User> findUsersByEmail(@PathVariable("email") String email)
    {
        return UserRepository.findUsersByEmail(email);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<User> ModifThisUser (@PathVariable int id, @RequestParam(required = false) String nom, @RequestParam(required = false) String prenom, @RequestParam(required = false) String email, @RequestParam(required = false) String numero) throws ResourceNotFoundException {
        User myUser = UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + id));
        if (nom != null) {
            myUser.setLastName(nom);
        }
        if (prenom != null) {
            myUser.setFirstName(prenom);
        }
        if (email != null) {
            myUser.setEmail(email);
        }
        if (numero != null) {
            myUser.setDob(numero);
        }
        UserRepository.save(myUser);
        return ResponseEntity.ok().body(myUser);
    }

    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.UserRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

}