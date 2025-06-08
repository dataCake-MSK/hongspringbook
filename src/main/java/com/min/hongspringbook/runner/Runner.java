package com.min.hongspringbook.runner;

import org.hibernate.annotations.Comment;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner ran with non-option args: " + args.getNonOptionArgs());
        System.out.println("and with args: " + args.getOptionNames() + args.getOptionValues("mykey"));
    }
}

