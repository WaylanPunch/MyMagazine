package com.waylanpunch.mymagazine.util;

import com.waylanpunch.mymagazine.model.ReturnResult;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/4/6 14:58
 */
public class ReturnResultUtil {

    /**
     * 无异常 请求成功并无具体内容返回
     * org.springframework.http.HttpStatus
     *
     * @return
     */
    public static ReturnResult<Object> sucess() {
        ReturnResult<Object> returnResult = new ReturnResult<Object>(0, "success", null);
        return returnResult;
    }

//    /**
//     * 无异常 请求成功并有具体内容返回
//     * org.springframework.http.HttpStatus
//     *
//     * @param object
//     * @return
//     */
//    public static ReturnResult<Object> sucess(Object object) {
//        ReturnResult<Object> returnResult = new ReturnResult<Object>(0, "success", object);
//        return returnResult;
//    }

    /**
     * 无异常 请求成功并无具体内容返回
     * org.springframework.http.HttpStatus
     *
     * @return
     */
    public static ReturnResult<Object> sucess(Integer code, String message) {
        ReturnResult<Object> returnResult = new ReturnResult<Object>(code, message, null);
        return returnResult;
    }

    /**
     * 无异常 请求成功并无具体内容返回
     * org.springframework.http.HttpStatus
     *
     * @return
     */
    public static ReturnResult<Object> sucess(Integer code, String message, Object object) {
        ReturnResult<Object> returnResult = new ReturnResult<Object>(code, message, object);
        return returnResult;
    }


    /**
     * 有自定义错误异常信息
     * org.springframework.http.HttpStatus
     *
     * @param code
     * @param msg
     * @return
     */
    public static ReturnResult<Object> error(Integer code, String msg) {
        ReturnResult<Object> returnResult = new ReturnResult<Object>(code, msg, null);
        return returnResult;
    }

}
