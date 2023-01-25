package com.example.springStudy.chap04.repository;

import com.example.springStudy.chap04.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
