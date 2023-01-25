package com.example.springStudy.chap05.config;

import com.example.springStudy.chap05.spring.MemberPrinter;
import com.example.springStudy.chap05.spring.VersionPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"spring"},
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, pattern = "spring.*Dao"))
public class AppCtx {

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }
//
//    @Bean
//    @Qualifier("summaryPrinter")
//    public MemberSummaryPrinter memberPrinter2(){
//        return new MemberSummaryPrinter();
//    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
