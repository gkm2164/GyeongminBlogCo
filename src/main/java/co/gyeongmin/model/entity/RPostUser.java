package co.gyeongmin.model.entity;

import javax.persistence.*;

/**
 * Created by USER on 2016-03-24.
 */
@Entity
@Table(name = "RPostUser")
public class RPostUser {
    @Id @GeneratedValue(generator = "RPostUserIDGenerator", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "RPostUserIDGenerator",
            table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "RPostUser",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PostID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
}
