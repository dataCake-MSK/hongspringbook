package com.min.hongspringbook.api;

import com.min.hongspringbook.entity.Article;
import com.min.hongspringbook.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleApiController {
    private final ArticleRepository articleRepository;

    @GetMapping("/api/articles")
    public List<Article> index(){
        return (List<Article>) articleRepository.findAll();
    }
}
