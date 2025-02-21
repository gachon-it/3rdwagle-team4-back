package com.habitmon.domain.habit.domain.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habit.domain.api.dto.request.CycleCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.response.CycleCreateResponse;
import com.habitmon.domain.habit.domain.api.dto.response.HabitCreateResponse;
import com.habitmon.domain.habit.domain.api.dto.response.HabitCycleCreateResponse;
import com.habitmon.domain.habit.domain.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habit")
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;

    @PostMapping("/create")
    public ApiResponse<HabitCycleCreateResponse> createHabit(
            @RequestBody HabitCreateRequest request,
            @RequestBody CycleCreateRequest requestByCycle) {
        HabitCreateResponse responseByHabit = habitService.createHabit(request);
        CycleCreateResponse responseByCycle = habitService.createCycle(requestByCycle);
        HabitCycleCreateResponse response = new HabitCycleCreateResponse(responseByHabit, responseByCycle);
        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
