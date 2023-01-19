package com.example.springStudy.chap02.config;

import com.example.springStudy.chap02.MemberListPrinter;
import com.example.springStudy.chap02.MemberPrinter;
import com.example.springStudy.chap02.entity.Member;
import com.example.springStudy.chap02.repository.MemberDao;
import com.example.springStudy.chap02.service.ChangePasswordService;
import com.example.springStudy.chap02.service.MemberRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao());
        return changePasswordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(memberDao(), memberPrinter());
    }
}