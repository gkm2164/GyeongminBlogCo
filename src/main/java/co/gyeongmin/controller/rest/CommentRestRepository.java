package co.gyeongmin.controller.rest;

import co.gyeongmin.abst.CRUDRestController;
import co.gyeongmin.model.entity.Comment;
import co.gyeongmin.model.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyeongmin on 3/24/16.
 */
@RestController
@RequestMapping("/comment.do")
public class CommentRestRepository extends CRUDRestController<Comment, Integer, CommentRepository> {
    @Autowired
    public CommentRestRepository(CommentRepository repository) {
        super(repository);
    }
}
