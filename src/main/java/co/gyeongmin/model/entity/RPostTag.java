package co.gyeongmin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "RPostTag")
public class RPostTag {
    @Id @GeneratedValue(generator = "RPostTagIDGenerator", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "RPostTagIDGenerator",
            table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "RPostTag",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PostID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "TagID")
    private Tag tag;
}
