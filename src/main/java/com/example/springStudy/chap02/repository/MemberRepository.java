package com.example.springStudy.chap02.repository;

import com.example.springStudy.chap02.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
