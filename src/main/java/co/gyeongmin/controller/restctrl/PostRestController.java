package co.gyeongmin.controller.restctrl;

import co.gyeongmin.abst.CRUDRestController;
import co.gyeongmin.model.entity.Post;
import co.gyeongmin.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post.do")
public class PostRestController extends CRUDRestController<Post, Integer, PostRepository> {
    @Autowired
    public PostRestController(PostRepository repository) {
        super(repository);
    }
}
