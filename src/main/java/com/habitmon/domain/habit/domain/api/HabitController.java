package com.habitmon.domain.habit.domain.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habit.domain.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.domain.api.dto.response.HabitCreateResponse;
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
    public ApiResponse<HabitCreateResponse> createHabit(
            @RequestBody HabitCreateRequest request) {
        HabitCreateResponse response = habitService.createHabit(request);
        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
