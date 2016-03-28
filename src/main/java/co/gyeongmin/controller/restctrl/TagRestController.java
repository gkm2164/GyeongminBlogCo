package co.gyeongmin.controller.restctrl;

import co.gyeongmin.abst.CRUDRestController;
import co.gyeongmin.model.entity.Tag;
import co.gyeongmin.model.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tag.do")
public class TagRestController extends CRUDRestController<Tag, Integer, TagRepository> {
    @Autowired
    public TagRestController(TagRepository repository) {
        super(repository);
    }
}
