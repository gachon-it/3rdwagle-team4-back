package com.habitmon.domain.member.service;

import com.habitmon.domain.member.api.dto.request.MemberRegisterRequest;
import com.habitmon.domain.member.api.dto.response.MemberInfoResponse;
import com.habitmon.domain.member.api.dto.response.MemberRegisterResponse;
import com.habitmon.domain.member.domain.Member;
import com.habitmon.domain.member.domain.repository.MemberRepository;
import com.habitmon.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberRegisterResponse registerMember(MemberRegisterRequest request) {
        Member member = memberRepository.save(
                Member.builder()
                        .nickname(request.nickname())
                        .ageRange(request.ageRange())
                        .gender(request.gender())
                        .build()
        );

        return new MemberRegisterResponse(member.getId());
    }

    public MemberInfoResponse memberInfo(long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);

        return new MemberInfoResponse(
                member.getId(),
                member.getNickname(),
                member.getAgeRange(),
                member.getGender()
        );
    }
}
