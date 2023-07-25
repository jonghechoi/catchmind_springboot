package com.springboot.catchmind.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

/**
 *  ResponseEntityExceptionHandler
 *  - 스프링 예외를 미리 처리해둔 추상 클래스
 *  - 스프링 예외에 대한 ExceptionHandler가 모두 구현되어 있음
 *  - 만약 이 추상 클래스를 상속받지 않으면 스프링 예외들은 DefaultHandlerExceptionResolver가 처리하게 되고
 *    러면 예외 처리기가 달라지므로 클라이언트는 일관되지 못한 에러 응답을 받게됨
 *    또한, 이 추상 클래스는 기본적으로 에러 메세지를 반환하지 않으므로 스프링 예외에 대한 에러 응답을 보내려면
 *    handleExceptionInternal 메소드를 override 해야함
 */
//@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException e) {
//        CommonErrorCode commonErrorCode = e.getErrorCode();
        CommonErrorCode commonErrorCode = (CommonErrorCode)e.getErrorCode();
        log.info(commonErrorCode.getMessage());

        ErrorResponseDto response = new ErrorResponseDto(commonErrorCode.getStatus(), commonErrorCode.getMessage());

        return new ResponseEntity<>(response, HttpStatus.valueOf(commonErrorCode.getStatus()));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             @Nullable Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
