package com.min.hongspringbook.runner;

import com.min.hongspringbook.dto.ArticleForm;
import com.min.hongspringbook.entity.Article;
import com.min.hongspringbook.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private final ArticleRepository articleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ArticleForm form = new ArticleForm(null, "TEST TITLE1", "TEST CONTENT1");
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        System.out.println("Saved dummy data: " + saved);

        form = new ArticleForm(null, "TEST TITLE2", "TEST CONTENT2");
        article = form.toEntity();
        saved = articleRepository.save(article);
        System.out.println("Saved dummy data: " + saved);
//        System.out.println("ApplicationRunner ran with non-option args: " + args.getNonOptionArgs());
//        System.out.println("and with args: " + args.getOptionNames() + args.getOptionValues("mykey"));
    }

}

