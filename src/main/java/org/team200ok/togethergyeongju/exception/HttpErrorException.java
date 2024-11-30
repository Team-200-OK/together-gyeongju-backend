package org.team200ok.togethergyeongju.exception;

import lombok.Getter;
import org.team200ok.togethergyeongju.config.HttpErrorCode;

@Getter
public class HttpErrorException extends RuntimeException{
    private final HttpErrorCode httpErrorCode;

    public HttpErrorException(HttpErrorCode httpErrorCode){
        super(httpErrorCode.getMessage());
        this.httpErrorCode = httpErrorCode;
    }
}

