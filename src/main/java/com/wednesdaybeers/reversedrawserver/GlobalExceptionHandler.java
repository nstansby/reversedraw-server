package com.wednesdaybeers.reversedrawserver;

import com.wednesdaybeers.reversedrawserver.dto.RestResponse;
import com.wednesdaybeers.reversedrawserver.dto.error.Error;
import com.wednesdaybeers.reversedrawserver.dto.error.ErrorCode;
import com.wednesdaybeers.reversedrawserver.processor.ReverseDrawException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ReverseDrawException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public @ResponseBody
    RestResponse reverseDrawException(HttpServletRequest request, HttpServletResponse response, ReverseDrawException e) {
        return e.toErrorDTO();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public @ResponseBody
    RestResponse handMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder("Parameter validation error(s): ");
        boolean first = true;
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(error.getDefaultMessage());
            first = false;
        }
        return new Error(ErrorCode.INVALID_PARAMETERS, sb.toString());
    }
}