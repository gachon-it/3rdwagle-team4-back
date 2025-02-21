package com.habitmon.domain.member.service;

import com.habitmon.domain.member.api.dto.request.MemberRegisterRequest;
import com.habitmon.domain.member.api.dto.response.MemberEmailCheckResponse;
import com.habitmon.domain.member.api.dto.response.MemberRegisterResponse;
import com.habitmon.domain.member.domain.Member;
import com.habitmon.domain.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberRegisterResponse registerMember(MemberRegisterRequest request) {
        Member member = memberRepository.save(
                Member.builder()
                        .email(request.email())
                        .password(request.password())
                        .nickname(request.nickname())
                        .gender(request.gender())
                        .job(request.job())
                        .build()
        );

        return new MemberRegisterResponse(member.getId(),"afdsf", "asgsbf");
    }

    public MemberEmailCheckResponse isDuplicatedEmail(MemberRegisterRequest request){
        Boolean doesMemberExistsByEmail= memberRepository.existsByEmail(request.email());

        return new MemberEmailCheckResponse(doesMemberExistsByEmail);
    }
}
