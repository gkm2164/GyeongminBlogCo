package co.gyeongmin.controller.web;

import co.gyeongmin.abst.LayoutController;
import co.gyeongmin.abst.PageDescription;
import co.gyeongmin.controller.auth.manager.AuthManager;
import co.gyeongmin.controller.web.exception.LackOfPermissionException;
import co.gyeongmin.model.entity.Comment;
import co.gyeongmin.model.entity.Post;
import co.gyeongmin.model.enumtype.CommentState;
import co.gyeongmin.model.enumtype.PostState;
import co.gyeongmin.model.repository.PostRepository;
import co.gyeongmin.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String newPost(HttpSession session, Model model) throws LackOfPermissionException {
        if (!AuthManager.isLoggedIn(session)) {
            throw new LackOfPermissionException("Posting new post is not allowed");
        }
        Integer userId = AuthManager.getUserID(session);
        Timestamp now = Timestamp.from(Instant.now());

        Post post = new Post();
        post.setUser(userRepository.findOne(userId));
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
    public String showPost(@PathVariable Integer id, HttpSession session, Model model){
        Post post = postRepository.findOne(id);

        Comment comment = new Comment();
        comment.setUser(userRepository.findAll().get(0));
        comment.setPost(post);
        comment.setStatus(CommentState.POST);
        comment.setCreatedTime(Timestamp.from(Instant.now()));

        Integer userId = AuthManager.getUserID(session);
        if (userId != null) {
            model.addAttribute("UserID", AuthManager.getUserID(session));
        }
        model.addAttribute("post", post);
        model.addAttribute("newComment", comment);

        PageDescription pdesc = new PageDescription(
                "post/show", "Show post",
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
    }

    @RequestMapping("/{id}/edit")
    public String editPost(@PathVariable Integer id, Model model) {
        model.addAttribute("post", postRepository.findOne(id));
        PageDescription pdesc = new PageDescription(
                "post/edit", "Edit post",
                (x, y, z) -> {}
        );
        return layoutCall(pdesc, model);
    }
}
