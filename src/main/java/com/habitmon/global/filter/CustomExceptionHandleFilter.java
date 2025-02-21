package com.habitmon.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.habitmon.common.ErrorCode;
import com.habitmon.common.exception.ServiceException;
import com.habitmon.common.response.ApiResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

public class CustomExceptionHandleFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain)
            throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            if (exception instanceof ServiceException se) {
                sendErrorResponse(response, se.getErrorCode());
            } else {
                sendErrorResponse(response, ErrorCode.INTERNAL_SERVER_ERROR);
            }
        }
    }

    private void sendErrorResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setStatus(errorCode.getHttpStatus());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        ApiResponse<Void> errorResponse = ApiResponse.error(errorCode);
        Map<String, ApiResponse<Void>> result = Map.of("result", errorResponse);

        new ObjectMapper().writeValue(response.getWriter(), result);
    }
}
