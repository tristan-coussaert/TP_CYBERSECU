package cou.cou.socialnetwork.Post;

import cou.cou.socialnetwork.User.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_creator")
    private User userCreator;

}
