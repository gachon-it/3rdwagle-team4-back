package com.habitmon.domain.habit.domain.service;

import com.habitmon.domain.habit.domain.Habit;
import com.habitmon.domain.habit.domain.api.dto.request.CycleCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.response.CycleCreateResponse;
import com.habitmon.domain.habit.domain.api.dto.response.HabitCreateResponse;
import com.habitmon.domain.habit.domain.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitService {

    private final HabitRepository habitRepository;
    private final CycleService cycleService;

    public HabitCreateResponse createHabit(HabitCreateRequest request){
        Habit habit = habitRepository.save(
                Habit.builder()
                        .name(request.name())
                        .startDate(request.start_date())
                        .endDate(request.end_date())
                        .complete(request.complete())
                        .build()
        );

             return new HabitCreateResponse(habit.getId(), "abc", "defg");
    }


    public CycleCreateResponse createCycle(CycleCreateRequest request){
        return cycleService.createCycle(request);
    }
}
