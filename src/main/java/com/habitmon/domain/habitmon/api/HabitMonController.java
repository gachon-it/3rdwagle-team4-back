package com.habitmon.domain.habitmon.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.habitmon.api.dto.request.HabitMonCreateRequest;
import com.habitmon.domain.habitmon.api.dto.response.HabitMonCreateResponse;
import com.habitmon.domain.habitmon.service.HabitMonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/habit")
public class HabitMonController {

    private final HabitMonService habitMonService;

    @PostMapping("/create")
    public ApiResponse<HabitMonCreateResponse> createHabitMon(
            @RequestBody HabitMonCreateRequest request) {
        HabitMonCreateResponse response = habitMonService.createHabitMon(request);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}
