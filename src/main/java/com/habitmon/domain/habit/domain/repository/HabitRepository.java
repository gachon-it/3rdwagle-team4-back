package com.habitmon.domain.habit.domain.repository;

import com.habitmon.domain.habit.domain.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    List<Habit> findAllByMemberId(Long memberId);
}

