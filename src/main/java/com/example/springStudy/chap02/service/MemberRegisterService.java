package com.example.springStudy.chap02.service;

import com.example.springStudy.chap02.entity.Member;
import com.example.springStudy.chap02.handle.DuplicateMemberException;
import com.example.springStudy.chap02.handle.RegisterRequest;
import com.example.springStudy.chap02.repository.MemberDao;
import com.example.springStudy.chap02.repository.MemberRepository;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao; // 생성이 아닌 전달을 통한 의존성 주입
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
