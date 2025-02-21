package com.habitmon.domain.habitmon.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habitmon.api.dto.request.HabitMonCreateRequest;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonCreateResponse;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonInfoResponse;
import com.habitmon.domain.habitmon.service.HabitMonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/habitmon")
public class HabitMonController {

    private final HabitMonService habitMonService;

    @PostMapping("/create")
    public ApiResponse<HabitMonCreateResponse> createHabitMon(
            @RequestBody HabitMonCreateRequest request) {
        HabitMonCreateResponse response = habitMonService.createHabitMon(request.memberId(), request);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }

    @GetMapping("{memberId}/info")
    public ApiResponse<HabitMonInfoResponse> habitMonInfo(
            @PathVariable Long memberId) {
        HabitMonInfoResponse response = habitMonService.findByHabitMonId(memberId);
        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
