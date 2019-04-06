package com.waylanpunch.mymagazine.model;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 * https://blog.csdn.net/ljk126wy/article/details/83243900
 * @author Waylan Punch
 * @date 2019/4/6 14:56
 */
public class ReturnResult<T> {

    /**
     * org.springframework.http.HttpStatus
     */
    private Integer code;//错误码
    private String message;//提示信息
    private T data;//返回具体内容

    public ReturnResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
