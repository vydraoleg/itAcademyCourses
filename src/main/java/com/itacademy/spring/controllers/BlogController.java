package com.itacademy.spring.controllers;

import com.itacademy.spring.models.BlogPost;
import com.itacademy.spring.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<BlogPost> blogPosts = blogPostRepository.findAll();
        model.addAttribute("posts", blogPosts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        BlogPost blogPost = new BlogPost(title, anons, full_text);
        blogPostRepository.save(blogPost);
        return "redirect:/blog";
    }

}
