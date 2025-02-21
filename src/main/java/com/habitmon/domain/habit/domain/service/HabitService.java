package com.habitmon.domain.habit.domain.service;

import com.habitmon.domain.habit.domain.Habit;
import com.habitmon.domain.habit.domain.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.response.HabitCreateResponse;
import com.habitmon.domain.habit.domain.api.dto.response.HabitListResponse;
import com.habitmon.domain.habit.domain.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitCreateResponse createHabit(HabitCreateRequest request) {
        Habit habit = habitRepository.save(
                Habit.builder()
                        .name(request.name())
                        .startDate(request.startDate())
                        .endDate(request.endDate())
                        .complete(false)
                        .count(request.count())
                        .period(request.period())
                        .build()
        );

        return new HabitCreateResponse(habit.getId());
    }

    public HabitListResponse getHabitList(Long memberId) {
        List<Habit> habits = habitRepository.findAllByMemberId(memberId);

        return new HabitListResponse(
                habits.stream().map(habit ->
                                new HabitListResponse.HabitResponse(
                                        habit.getId(), habit.getName()))
                        .toList()
        );
    }
}
