package com.habitmon.domain.habitmon.domain.repository;

import com.habitmon.domain.habitmon.domain.HabitMon;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitMonRepository extends JpaRepository<HabitMon, Long> {

    HabitMonInfoResponse findByMemberId(Long memberId);
}
