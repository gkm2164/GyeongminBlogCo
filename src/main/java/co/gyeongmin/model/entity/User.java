package co.gyeongmin.model.entity;

import co.gyeongmin.model.enumtype.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by USER on 2016-03-24.
 */
@Entity
@Table(name = "Users")
@Getter @Setter
@EqualsAndHashCode(exclude = {"posts", "comments"})
public class User {
    @Id @GeneratedValue(generator = "UserIDGenerator", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "UserIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Users",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    private Integer id;

    private String userName;

    private String password;

    private String email;

    private String profile;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany
    @JoinTable(
            name = "RPostUser",
            joinColumns = @JoinColumn(name = "UserID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PostID", referencedColumnName = "ID")
    )
    private List<Post> posts;

    @OneToMany
    @JoinTable(
            name = "RCommentUser",
            joinColumns = @JoinColumn(name = "UserID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CommentID", referencedColumnName = "ID")
    )
    private List<Comment> comments;
}
