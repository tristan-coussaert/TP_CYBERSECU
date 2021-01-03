package cou.cou.socialnetwork.Post;

import cou.cou.socialnetwork.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Set;

@RepositoryRestResource(path="post")
public interface PostRepository extends JpaRepository<Post, Integer> {

    public Set<Post> findPostsByName(@PathVariable("name") String name);
}
