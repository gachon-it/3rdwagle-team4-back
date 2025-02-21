package com.habitmon.domain.member.domain.repository;

import com.habitmon.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //public Member findByEmail(String email);
    boolean existsByEmail(String email);
}
