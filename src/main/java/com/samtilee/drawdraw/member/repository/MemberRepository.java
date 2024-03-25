package com.samtilee.drawdraw.member.repository;

import com.samtilee.drawdraw.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
