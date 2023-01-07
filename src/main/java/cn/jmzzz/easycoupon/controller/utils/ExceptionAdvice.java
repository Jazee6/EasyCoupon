package cn.jmzzz.easycoupon.controller.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler
    public R handleException(Exception e) {
        log.error(e.getMessage());
        return new R(Code.ERROR, Msg.ERROR);
    }

}
