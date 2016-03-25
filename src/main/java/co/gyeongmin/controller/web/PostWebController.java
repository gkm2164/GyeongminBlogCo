package co.gyeongmin.controller.web;

import co.gyeongmin.abst.LayoutController;
import co.gyeongmin.abst.PageDescription;
import co.gyeongmin.model.entity.Post;
import co.gyeongmin.model.enumtype.PostState;
import co.gyeongmin.model.repository.PostRepository;
import co.gyeongmin.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.Instant;

@Controller
@RequestMapping("post")
public class PostWebController extends LayoutController {
    private @Autowired PostRepository postRepository;
    private @Autowired UserRepository userRepository;
    @RequestMapping
    public String postIndex(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        PageDescription pdesc = new PageDescription(
                "post/list", "Post List",
                (css, hjs, fjs) -> {
                    hjs.add("/js/post.list.js");
                }
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping("new")
    public String newPost(Model model) {
        Timestamp now = Timestamp.from(Instant.now());

        Post post = new Post();
        post.setUser(userRepository.findOne(0));
        post.setStatus(PostState.POST);
        post.setCreatedTime(now);
        post.setModifiedTime(now);
        model.addAttribute("post", post);
        PageDescription pdesc = new PageDescription(
                "post/new", "Post List",
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
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
