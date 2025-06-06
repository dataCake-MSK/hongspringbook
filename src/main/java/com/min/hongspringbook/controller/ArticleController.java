package com.min.hongspringbook.controller;
import com.min.hongspringbook.dto.ArticleForm;
import com.min.hongspringbook.entity.Article;
import com.min.hongspringbook.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleFrom(){
        return "articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info(String.valueOf(id));
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // .orElseGet(() -> new Article()); for default entity
        model.addAttribute("article", articleEntity);
        return "articles/show";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString()); // System.out.println(form.toString());
        Article article = form.toEntity();
        log.info(article.toString());
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "articles/new";
    }
//
    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }
}


