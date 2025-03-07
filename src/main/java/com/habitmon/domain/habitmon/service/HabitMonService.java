package com.habitmon.domain.habitmon.service;

import com.habitmon.domain.habitmon.domain.HabitMon;
import com.habitmon.domain.habitmon.api.dto.request.HabitMonCreateRequest;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonCreateResponse;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonInfoResponse;
import com.habitmon.domain.habitmon.domain.repository.HabitMonRepository;
import com.habitmon.domain.member.domain.Member;
import com.habitmon.domain.member.domain.repository.MemberRepository;
import com.habitmon.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.habitmon.domain.habitmon.domain.Age.BABY;

@Service
@RequiredArgsConstructor
public class HabitMonService {
    private final HabitMonRepository habitMonRepository;

    private final MemberRepository memberRepository;

    @Transactional
    public HabitMonCreateResponse createHabitMon(Long memberId, HabitMonCreateRequest request){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        HabitMon habitmon = habitMonRepository.save(
                HabitMon.builder()
                        .member(member)
                        .name(request.name())
                        .age(BABY.getValue())
                        .build()
        );

        return new HabitMonCreateResponse(habitmon.getId());
    }

    public HabitMonInfoResponse findByHabitMonId(Long memberId){
        return habitMonRepository.findByMemberId(memberId);
    }
}
