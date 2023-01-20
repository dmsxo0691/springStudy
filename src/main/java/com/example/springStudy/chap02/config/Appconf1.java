package com.example.springStudy.chap02.config;

import com.example.springStudy.chap02.MemberPrinter;
import com.example.springStudy.chap02.repository.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconf1 {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
}
