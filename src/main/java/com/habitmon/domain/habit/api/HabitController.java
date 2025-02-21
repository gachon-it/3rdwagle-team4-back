package com.habitmon.domain.habit.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habit.api.dto.request.HabitCreateRequest;
import com.habitmon.domain.habit.api.dto.request.HabitInfoRequest;
import com.habitmon.domain.habit.api.dto.response.HabitCreateResponse;
import com.habitmon.domain.habit.api.dto.response.HabitInfoResponse;
import com.habitmon.domain.habit.api.dto.response.HabitListResponse;
import com.habitmon.domain.habit.service.HabitService;
import com.habitmon.global.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/list")
    public ApiResponse<HabitListResponse> habitList(
            @AuthenticationPrincipal AuthDetails authDetails){
        long memberId = authDetails.id();
        HabitListResponse response = habitService.getHabitList(memberId);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }

    @GetMapping("/info")
    public ApiResponse<HabitInfoResponse> habitInfo(
            @RequestBody HabitInfoRequest request){
        HabitInfoResponse response = habitService.getHabitInfo(request);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
