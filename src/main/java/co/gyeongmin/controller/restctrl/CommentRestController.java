package co.gyeongmin.controller.restctrl;

import co.gyeongmin.abst.CRUDRestController;
import co.gyeongmin.model.entity.Comment;
import co.gyeongmin.model.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment.do")
public class CommentRestController extends CRUDRestController<Comment, Integer, CommentRepository> {
    @Autowired
    public CommentRestController(CommentRepository repository) {
        super(repository);
    }
}
