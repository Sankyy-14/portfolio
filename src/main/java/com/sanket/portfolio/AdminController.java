package com.sanket.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PostRepository postRepository;

    public AdminController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postRepository.findAllByOrderByCreatedAtDesc());
        return "admin";
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "admin-form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElseThrow());
        return "admin-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String title,
                       @RequestParam String summary,
                       @RequestParam String content) {
        Post post = (id == null) ? new Post() : postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setSummary(summary);
        post.setContent(content);
        postRepository.save(post);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/admin";
    }
}
