package cou.cou.socialnetwork.Post;

import cou.cou.socialnetwork.Post.Post;
import cou.cou.socialnetwork.Post.PostRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="post")
public class PostController {
    @Autowired
    private PostRepository PostRepository;

    @GetMapping
    public Iterable<Post> getPosts()
    {
        return PostRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPost(@PathVariable("id") int id)
    {
        return PostRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Post> findPostsByName(@PathVariable("name") String name)
    {
        return PostRepository.findPostsByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteThisPost(@PathVariable int id) throws ResourceNotFoundException {
        Post i = PostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        PostRepository.delete(i);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Post> ModifThisPost(@PathVariable int id, @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String content) throws ResourceNotFoundException{
        Post myPost = PostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found :: " + id));
        if (name != null) {
            myPost.setName(name);
        }
        if (content != null) {
            myPost.setContent(content);
        }
        PostRepository.save(myPost);
        return ResponseEntity.ok().body(myPost);
    }

    @PostMapping("/add")
    public void createPost(@RequestBody Post newPost) {
        if (!PostRepository.existsById(newPost.getId())) {
            PostRepository.save(newPost);
        }
    }
}