package dev.jlkeesh.controller;

import dev.jlkeesh.dao.BlogDAO;
import dev.jlkeesh.domain.Blog;
import dev.jlkeesh.dto.BlogCreateDTO;
import dev.jlkeesh.mapper.BlogMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final BlogDAO blogDAO;
    private final BlogMapper blogMapper;

    public BlogController(BlogDAO blogDAO, BlogMapper blogMapper) {
        this.blogDAO = blogDAO;
        this.blogMapper = blogMapper;
    }

    @GetMapping
    public String list(Model model) {
        List<Blog> blogs = blogDAO.getAll();
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping("/create")
    public String createPage() {
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogCreateDTO dto) {
        Blog blog = blogMapper.fromCreateDTO(dto);
        blogDAO.save(blog);
        return "redirect:/blog/create";
    }
}
