package com.habitmon.domain.habit.domain.service;

import com.habitmon.domain.habit.domain.Cycle;
import com.habitmon.domain.habit.domain.Habit;
import com.habitmon.domain.habit.domain.api.dto.request.CycleCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.response.CycleCreateResponse;
import com.habitmon.domain.habit.domain.api.dto.response.HabitCreateResponse;
import com.habitmon.domain.habit.domain.repository.CycleRepository;
import com.habitmon.domain.habit.domain.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CycleService {

    private final CycleRepository cycleRepository;

    public CycleCreateResponse createCycle(CycleCreateRequest request){
        Cycle cycle = cycleRepository.save(
                Cycle.builder()
                        .habit(request.habit())
                        .period(request.period())
                        .count(request.count())
                        .build()
        );
        return new CycleCreateResponse(cycle.getId(), "abc", "defg");
    }


}