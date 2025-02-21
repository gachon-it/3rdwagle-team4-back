package com.habitmon.domain.member.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.member.api.dto.request.MemberRegisterRequest;
import com.habitmon.domain.member.api.dto.response.MemberEmailCheckResponse;
import com.habitmon.domain.member.api.dto.response.MemberRegisterResponse;
import com.habitmon.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.objenesis.ObjenesisHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/register")
    public ApiResponse<MemberRegisterResponse> registerMember(
            @RequestBody MemberRegisterRequest request) {
        MemberRegisterResponse response = memberService.registerMember(request);
        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }

    @PostMapping("/is-duplicated-email")
    public ApiResponse<MemberEmailCheckResponse> isDuplicatedEmail(
            @RequestBody MemberRegisterRequest request){
        MemberEmailCheckResponse response = memberService.isDuplicatedEmail(request);
        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }


}
