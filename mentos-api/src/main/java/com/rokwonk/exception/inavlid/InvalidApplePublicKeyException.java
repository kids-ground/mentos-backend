package com.rokwonk.exception.inavlid;

import com.rokwonk.exception.MentosException;
import org.springframework.http.HttpStatus;

public class InvalidApplePublicKeyException extends MentosException {

    public InvalidApplePublicKeyException() {
        super(HttpStatus.BAD_REQUEST, "인증실패", 400);
    }
}
