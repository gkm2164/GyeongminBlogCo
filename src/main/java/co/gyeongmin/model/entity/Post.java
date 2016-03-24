package co.gyeongmin.model.entity;

import co.gyeongmin.model.enumtype.PostState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Posts")
@Getter @Setter
@EqualsAndHashCode(exclude = {"user", "tags", "comments"})
public class Post {
    @Id
    @TableGenerator(
            name = "PostIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Posts",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(
            generator = "PostIDGenerator",
            strategy = GenerationType.TABLE
    )
    private Integer id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private PostState status;

    private Timestamp createdTime;

    private Timestamp modifiedTime;

    @ManyToOne
    @JoinTable(
            name = "RPostUser",
            joinColumns = @JoinColumn(name = "PostID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "UserID", referencedColumnName = "ID")
    )
    @JsonBackReference
    private User user;

    @ManyToMany
    @JoinTable(
            name = "RPostTag",
            joinColumns = @JoinColumn(name = "PostID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TagID", referencedColumnName = "ID")
    )
    private List<Tag> tags;

    @OneToMany
    @JoinTable(
            name = "RCommentPost",
            joinColumns = @JoinColumn(name = "PostID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CommentID", referencedColumnName = "ID")
    )
    private List<Comment> comments;
}