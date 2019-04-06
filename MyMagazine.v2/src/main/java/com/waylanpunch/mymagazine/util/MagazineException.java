package com.waylanpunch.mymagazine.util;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/4/2 23:07
 */
public class MagazineException extends RuntimeException {

    /**
     * org.springframework.http.HttpStatus
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MagazineException(Integer code, String message) {
        super(message);
        this.code = code;
    }

//    public MagazineException(String message, Throwable cause) {
//        super(message, cause);
//    }
}
