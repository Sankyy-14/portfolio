package com.sanket.portfolio;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class BlogController {

    private final PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("posts", postRepository.findAllByOrderByCreatedAtDesc());
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("post", post);
        return "post";
    }
}
