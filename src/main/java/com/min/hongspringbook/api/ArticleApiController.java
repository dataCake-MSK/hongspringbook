package com.min.hongspringbook.api;

import com.min.hongspringbook.dto.ArticleForm;
import com.min.hongspringbook.entity.Article;
import com.min.hongspringbook.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleApiController {
    private final ArticleRepository articleRepository;

    @GetMapping("/api/articles")
    public ResponseEntity<?> index(){
        return ResponseEntity.status(HttpStatus.OK).body(articleRepository.findAll());
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        if (!Objects.equals(id, article.getId())){
            log.info(String.valueOf(article.getId()));
            log.info("Body and URL id mismatch!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Body and URL id mismatch!");
        }
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null){
            String message = String.format("Id %d Entity doesn't exist", id);
            log.info(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        Article updated = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
