package co.gyeongmin.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by USER on 2016-03-29.
 */
@Controller
@RequestMapping
public class IndexController {
    @RequestMapping
    public String home() {
        return "redirect:/post";
    }
}
