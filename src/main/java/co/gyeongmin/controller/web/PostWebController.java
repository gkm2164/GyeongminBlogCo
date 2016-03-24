package co.gyeongmin.controller.web;

import co.gyeongmin.model.entity.Post;
import co.gyeongmin.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by gyeongmin on 3/24/16.
 */
@Controller
@RequestMapping("/post")
public class PostWebController {
    private @Autowired PostRepository postRepository;
    @RequestMapping("/")
    public String postIndex(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "post/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPost(Model model) {
        Timestamp now = Timestamp.from(Instant.now());

        Post post = new Post();
        post.setCreatedTime(now);
        post.setModifiedTime(now);
        model.addAttribute("post", post);
        return "post/new";
    }

    @RequestMapping("/{id}/show")
    public String showPost(@PathVariable Integer id, Model model){
        model.addAttribute("post", postRepository.findOne(id));
        return "post/show";
    }

    @RequestMapping("/{id}/edit")
    public String editPost(@PathVariable Integer id, Model model) {
        return "post/edit";
    }

    @RequestMapping("/{id}/remove")
    public String removePost(@PathVariable Integer id, Model model) {
        return "redirect:/post";
    }
}