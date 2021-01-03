package cou.cou.socialnetwork.Friend;

import cou.cou.socialnetwork.User.User;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "friend_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_sender")
    private User userSender;

    @ManyToOne
    @JoinColumn(name = "user_receiver")
    private User userReceiver;

    @Column(name = "accepted")
    private Boolean accepted;
}