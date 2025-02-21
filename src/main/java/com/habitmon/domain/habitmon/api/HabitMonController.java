package com.habitmon.domain.habitmon.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habitmon.api.dto.request.HabitMonCreateRequest;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonCreateResponse;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonInfoResponse;
import com.habitmon.domain.habitmon.service.HabitMonService;
import com.habitmon.global.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/habitmon")
public class HabitMonController {

    private final HabitMonService habitMonService;

    @PostMapping("/create")
    public ApiResponse<HabitMonCreateResponse> createHabitMon(
            @AuthenticationPrincipal AuthDetails authDetails,
            @RequestBody HabitMonCreateRequest request) {
        long memberId = authDetails.id();
        HabitMonCreateResponse response = habitMonService.createHabitMon(memberId, request);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }

    @GetMapping("/info")
    public ApiResponse<HabitMonInfoResponse> habitMonInfo(
            @AuthenticationPrincipal AuthDetails authDetails) {
        long memberId = authDetails.id();
        HabitMonInfoResponse response = habitMonService.findByHabitMonId(memberId);
        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
