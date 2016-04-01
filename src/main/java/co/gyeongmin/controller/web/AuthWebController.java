package co.gyeongmin.controller.web;

import co.gyeongmin.abst.LayoutController;
import co.gyeongmin.abst.PageDescription;
import co.gyeongmin.controller.restctrl.AuthRestRepository.AuthObject;
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
}
