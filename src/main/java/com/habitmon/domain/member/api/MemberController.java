package com.habitmon.domain.member.api;

import com.habitmon.common.SuccessCode;
import com.habitmon.common.response.ApiResponse;
import com.habitmon.domain.member.api.dto.request.EmailDuplicateCheckRequest;
import com.habitmon.domain.member.api.dto.request.MemberRegisterRequest;
import com.habitmon.domain.member.api.dto.response.MemberEmailCheckResponse;
import com.habitmon.domain.member.api.dto.response.MemberInfoResponse;
import com.habitmon.domain.member.api.dto.response.MemberRegisterResponse;
import com.habitmon.domain.member.service.MemberService;
import com.habitmon.global.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/info/{memberId")
    public ApiResponse<MemberInfoResponse> memberInfo(
            @RequestParam Long memberId) {
        MemberInfoResponse response = memberService.memberInfo(memberId);

        return ApiResponse.success(SuccessCode.REQUEST_OK, response);
    }
}

