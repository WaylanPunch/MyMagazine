package com.waylanpunch.mymagazine.util;

import com.waylanpunch.mymagazine.model.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/4/6 15:10
 */
@RestControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    //@ResponseBody
    public ReturnResult<Object> handle(Exception exception) {
        if (exception instanceof MagazineException) {
            MagazineException magazineException = (MagazineException) exception;
            return ReturnResultUtil.error(magazineException.getCode(), magazineException.getMessage());
        } else {
            logger.error("系统异常 {}", exception);
            return ReturnResultUtil.error(-1, "未知异常" + exception.getMessage());
        }
    }

}
