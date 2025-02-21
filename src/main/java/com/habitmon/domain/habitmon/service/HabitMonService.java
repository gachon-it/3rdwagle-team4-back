package com.habitmon.domain.habitmon.service;

import com.habitmon.domain.habit.domain.HabitMon;
import com.habitmon.domain.habitmon.api.dto.request.HabitMonCreateRequest;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonCreateResponse;
import com.habitmon.domain.habitmon.domain.repository.HabitMonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.habitmon.domain.habitmon.domain.Age.BABY;

@Service
@RequiredArgsConstructor
public class HabitMonService {
    private final HabitMonRepository habitMonRepository;

    @Transactional
    public HabitMonCreateResponse createHabitMon(HabitMonCreateRequest request){
        HabitMon habitmon = habitMonRepository.save(
                HabitMon.builder()
                        .name(request.name())
                        .age(BABY.value())
                        .build()
        );

        return new HabitMonCreateResponse(habitmon.getId());
    }
}
