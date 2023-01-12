package com.itacademy.spring.controllers;

import com.itacademy.spring.models.BlogPost;
import com.itacademy.spring.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!blogPostRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        ArrayList<BlogPost> res = new ArrayList<>();  // Описываем массив
        blogPost.ifPresent(res::add);   //загоняем все в него
        model.addAttribute("post", res);
        return "blog-details";
    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!blogPostRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        ArrayList<BlogPost> res = new ArrayList<>();  // Описываем массив
        blogPost.ifPresent(res::add);   //загоняем все в него
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow();
        blogPost.setTitle(title);
        blogPost.setAnons(anons);
        blogPost.setFull_text(full_text);
        blogPostRepository.save(blogPost);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow();
        blogPostRepository.delete(blogPost);
        return "redirect:/blog";
    }
}
