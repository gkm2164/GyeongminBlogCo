package co.gyeongmin.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by USER on 2016-03-24.
 */
@Entity
@Table(name = "Tags")
@Getter @Setter
public class Tag {
    @Id @GeneratedValue(generator = "TagIDGenerator", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "TagIDGenerator",
            table = "SurrogateKeys",
            pkColumnName = "TableName", pkColumnValue = "Tags",
            valueColumnName = "KeyValue", initialValue = 0,
            allocationSize = 1
    )
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "RPostTag",
            joinColumns = @JoinColumn(name = "TagID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PostID", referencedColumnName = "ID")
    )
    @JsonBackReference
    private List<Post> posts;
}
