package com.rokwonk.exception.unauthorized;

import com.rokwonk.exception.MentosException;
import com.rokwonk.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public class MentosUnauthorizedException extends MentosException {
    public MentosUnauthorizedException(ErrorCode errorCode) {
        super(HttpStatus.UNAUTHORIZED, errorCode.getMessage(), errorCode.getCode());
    }
}
