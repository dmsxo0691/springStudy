package com.example.springStudy.chap02;

import com.example.springStudy.chap02.entity.Member;
import com.example.springStudy.chap02.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            System.out.println("데이터 없음\n");
            return;
        }
        memberPrinter.print(member);
        System.out.println();
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    @Autowired
    public void setMemberPrinter(MemberPrinter memberPrinter){
        this.memberPrinter = memberPrinter;
    }
}
