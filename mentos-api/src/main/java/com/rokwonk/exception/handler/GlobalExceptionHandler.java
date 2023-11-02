package com.rokwonk.exception.handler;

import com.rokwonk.dto.response.ErrorResponse;
import com.rokwonk.exception.MentosException;
import com.rokwonk.exception.code.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 없는 API 호출
    @ExceptionHandler({
        MethodArgumentTypeMismatchException.class, // 요청 타입 불일치(바인딩 에러)
        HttpRequestMethodNotSupportedException.class // 지원하지 않는 HTTP Method
    })
    public ResponseEntity<ErrorResponse> handleNotFulfilledException(Exception e) {
        ErrorCode errorCode = ErrorCode.INVALID_REQUEST;

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
    }

    // @Valid 예외
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorCode errorCode = ErrorCode.INVALID_REQUEST;

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
    }

    // 예외 처리
    @ExceptionHandler(MentosException.class)
    public ResponseEntity<ErrorResponse> handleKeymeException(MentosException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(new ErrorResponse(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("서버 로직 중 잘못된 인자를 넘기고 있습니다. {}", e.getCause());
        ErrorCode errorCode = ErrorCode.SERVER_ERROR;

        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnHandleException(Exception e) {
        log.error("예상치 못한 에러발생! 😭 {} {} {}", e.getCause(), e.getMessage(), Arrays.toString(e.getStackTrace()));
        ErrorCode errorCode = ErrorCode.SERVER_ERROR;

        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
    }
}
