package com.example.springStudy.chap04.service;

import com.example.springStudy.chap04.entity.Member;
import com.example.springStudy.chap04.handle.MemberNotFoundException;
import com.example.springStudy.chap04.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
    @Autowired
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd){
        Member member = memberDao.selectByEmail(email);
        if(member == null) {
            throw new MemberNotFoundException();
        }
            member.changePassword(oldPwd,newPwd);

            memberDao.update(member);
    }
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
}
