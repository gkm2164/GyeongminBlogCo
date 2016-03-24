package co.gyeongmin.model.entity;

import javax.persistence.*;

/**
 * Created by USER on 2016-03-24.
 */
@Entity
@Table(name = "RCommentUser")
public class RCommentUser {
    @Id @GeneratedValue(generator = "RCommentUserIDGenerator", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "RCommentUserIDGenerator",
            table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "RCommentUser",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CommentID")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
}
