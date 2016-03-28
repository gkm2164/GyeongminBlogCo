package co.gyeongmin.controller.restctrl;

import co.gyeongmin.abst.Result;
import co.gyeongmin.model.entity.User;
import co.gyeongmin.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by gyeongmin on 3/28/16.
 */
@RestController
@RequestMapping("/auth.do")
public class AuthRestRepository {
    @Autowired UserRepository ur;

    @RequestMapping("/login")
    public Result doLogin(@ModelAttribute AuthObject authObject,
                          BindingResult bindingResult,
                          HttpSession httpSession) {
        Result result = new Result();
        User user = ur.findByEmail(authObject.getId());

        if (user == null) {
            result.setSuccess(false);
            return result;
        }

        if (!user.getPassword().equals(authObject.getPassword())) {
            result.setSuccess(false);
            return result;
        }

        httpSession.setAttribute("UserID", user.getId());
        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/logout")
    public Result doLogout(HttpSession httpSession) {
        Result result = new Result();

        if (httpSession.getAttribute("UserID") != null) {
            httpSession.removeAttribute("UserID");
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }
}
