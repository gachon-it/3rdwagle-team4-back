package com.habitmon.domain.habit.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habit.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.api.dto.response.HabitCreateResponse;
import com.habitmon.domain.habit.api.dto.response.HabitInfoResponse;
import com.habitmon.domain.habit.api.dto.response.HabitListResponse;
import com.habitmon.domain.habit.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{memberId}/list")
    public ApiResponse<HabitListResponse> habitList(
            @PathVariable Long memberId){
        HabitListResponse response = habitService.getHabitList(memberId);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }

    @GetMapping("{habitId}/info")
    public ApiResponse<HabitInfoResponse> habitInfo(
            @PathVariable Long habitId){
        HabitInfoResponse response = habitService.getHabitInfo(habitId);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
