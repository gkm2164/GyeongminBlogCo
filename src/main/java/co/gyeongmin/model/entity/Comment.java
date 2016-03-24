package co.gyeongmin.model.entity;

import co.gyeongmin.model.enumtype.CommentState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Comments")
@Getter @Setter
@EqualsAndHashCode(exclude = {"post", "user"})
public class Comment {
    @Id  @TableGenerator(
            name = "CommentIDGenerator", table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Comments",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(
            generator = "CommentIDGenerator",
            strategy = GenerationType.TABLE
    )
    private Integer id;

    private String content;

    @Enumerated(EnumType.STRING)
    private CommentState status;

    private Timestamp createdTime;

    @ManyToOne
    @JoinTable(
            name = "RCommentPost",
            joinColumns = @JoinColumn(name = "CommentID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PostID", referencedColumnName = "ID")
    )
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinTable(
            name = "RCommentUser",
            joinColumns = @JoinColumn(name = "CommentID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "UserID", referencedColumnName = "ID")
    )
    @JsonBackReference
    private User user;
}
