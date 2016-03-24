package co.gyeongmin.controller.rest;

import co.gyeongmin.abst.CRUDRestController;
import co.gyeongmin.model.entity.User;
import co.gyeongmin.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user.do")
public class UserRestController extends CRUDRestController<User, Integer, UserRepository> {
    @Autowired
    public UserRestController(UserRepository repository) {
        super(repository);
    }
}
