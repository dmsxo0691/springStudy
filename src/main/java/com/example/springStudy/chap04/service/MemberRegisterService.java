package com.example.springStudy.chap04.service;

import com.example.springStudy.chap04.entity.Member;
import com.example.springStudy.chap04.handle.DuplicateMemberException;
import com.example.springStudy.chap04.handle.RegisterRequest;
import com.example.springStudy.chap04.repository.MemberDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
public class MemberRegisterService {
    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService(){
    }

    public Long regist(RegisterRequest request){
        Member member = memberDao.selectByEmail(request.getEmail());
        if(member != null){
            throw new DuplicateMemberException("dup email" + request.getEmail());
        }
        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), LocalDateTime.now());
        memberDao.insert(newMember);

        return newMember.getId();
    }

}
