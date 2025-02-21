package com.habitmon.domain.habitmon.domain.repository;

import com.habitmon.domain.habit.domain.HabitMon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitMonRepository extends JpaRepository<HabitMon, Long> {
}
