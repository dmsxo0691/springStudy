package com.example.springStudy.chap02.service;

import com.example.springStudy.chap02.entity.Member;
import com.example.springStudy.chap02.handle.MemberNotFoundException;
import com.example.springStudy.chap02.repository.MemberDao;

public class ChangePasswordService {
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