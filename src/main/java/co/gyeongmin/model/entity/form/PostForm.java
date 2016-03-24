package co.gyeongmin.model.entity.form;

import co.gyeongmin.model.enumtype.PostState;

import java.sql.Timestamp;

/**
 * Created by gyeongmin on 3/24/16.
 */
public class PostForm {
    private Integer id;
    private String text;
    private String content;
    private PostState status;
}
