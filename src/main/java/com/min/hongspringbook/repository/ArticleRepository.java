package com.min.hongspringbook.repository;

import com.min.hongspringbook.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
