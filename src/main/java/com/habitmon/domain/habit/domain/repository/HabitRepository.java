package com.habitmon.domain.habit.domain.repository;

import com.habitmon.domain.habit.domain.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}
