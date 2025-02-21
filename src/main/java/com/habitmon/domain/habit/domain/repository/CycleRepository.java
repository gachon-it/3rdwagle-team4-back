package com.habitmon.domain.habit.domain.repository;

import com.habitmon.domain.habit.domain.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleRepository extends JpaRepository<Cycle, Long> {
}
