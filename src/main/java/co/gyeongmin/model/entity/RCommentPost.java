package co.gyeongmin.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by USER on 2016-03-24.
 */
@Entity
@Table(name = "RCommentPost")
@Getter @Setter
public class RCommentPost {
    @Id @GeneratedValue(generator = "RCommentPostIDGenerator", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "RCommentPostIDGenerator",
            table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "RCommentPost",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CommentID")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "PostID")
    private Post post;
}
