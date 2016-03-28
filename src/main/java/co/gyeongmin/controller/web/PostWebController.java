package co.gyeongmin.controller.web;

import co.gyeongmin.abst.LayoutController;
import co.gyeongmin.abst.PageDescription;
import co.gyeongmin.model.entity.Post;
import co.gyeongmin.model.enumtype.PostState;
import co.gyeongmin.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.time.Instant;

@Controller
@RequestMapping("/post")
public class PostWebController extends LayoutController {
    private @Autowired PostRepository postRepository;
    @RequestMapping("/")
    public String postIndex(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        PageDescription pdesc = new PageDescription(
                "post/list" ,"Post list",
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPost(Model model) {
        Timestamp now = Timestamp.from(Instant.now());

        Post post = new Post();
        post.setStatus(PostState.POST);
        post.setCreatedTime(now);
        post.setModifiedTime(now);
        model.addAttribute("post", post);
        PageDescription pdesc = new PageDescription(
                "post/new" ,"New Post",
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping("/{id}/show")
    public String showPost(@PathVariable Integer id, Model model){
        Post post = postRepository.findOne(id);
        model.addAttribute("post", post);
        PageDescription pdesc = new PageDescription(
                "post/show", post.getTitle(),
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping("/{id}/edit")
    public String editPost(@PathVariable Integer id, Model model) {
        Post post = postRepository.findOne(id);
        model.addAttribute("post", post);
        PageDescription pdesc = new PageDescription(
                "post/edit", post.getTitle() + " Edit",
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping("/{id}/remove")
    public String removePost(@PathVariable Integer id, Model model) {
        return "redirect:/post";
    }
}
