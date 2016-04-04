package co.gyeongmin.controller.web;

import co.gyeongmin.abst.LayoutController;
import co.gyeongmin.abst.PageDescription;
import co.gyeongmin.controller.auth.entity.AuthObject;
import co.gyeongmin.model.entity.User;
import co.gyeongmin.model.enumtype.UserType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gyeongmin on 3/28/16.
 */
@Controller
@RequestMapping("/auth")
public class AuthWebController extends LayoutController {

    @RequestMapping
    public String authPage(Model model) {
        AuthObject authObject = new AuthObject();

        model.addAttribute("AUTH", authObject);
        PageDescription pdesc = new PageDescription(
                "auth/login",
                "Login Page",
                (css, hjs, z) -> {
                    hjs.add("/js/auth.js");
                    css.add("/css/auth/auth.css");
                }
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping("new")
    public String createUser(Model model) {
        User user = new User();

        user.setUserType(UserType.KNOWNUSER);

        model.addAttribute("user", user);
        PageDescription pdesc = new PageDescription(
                "auth/new",
                "Create User Page",
                (css, hjs, z) -> {
                    hjs.add("/js/auth.new.js");
                    css.add("/css/auth/auth.css");
                }
        );

        return layoutCall(pdesc, model);
    }
}
