package com.min.hongspringbook.controller;

import com.min.hongspringbook.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
@GetMapping("/articles/new")
    public String newArticleFrom(){
        return "articles/new";
    }

@PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
    return "";
    }
}


