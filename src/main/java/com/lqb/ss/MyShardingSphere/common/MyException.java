package com.lqb.ss.MyShardingSphere.common;

import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

/**
 * @author JingFeng.Tan
 * @version 1.0.0
 * @date 2018-09-17
 */
public class MyException extends Exception {
    private int status;

    /**
     *  给定异常状态，默认异常信息为空
     * @param exceptionCode 给定的异常状态
     */
    public MyException(ExceptionCode exceptionCode) {
        this(exceptionCode, StringUtils.EMPTY, null);
    }

    /**
     * 给定异常状态和异常信息
     * @param exceptionCode 异常状态
     * @param message 异常信息
     */
    public MyException(ExceptionCode exceptionCode, String message) {
        this(exceptionCode, message, null);
    }

    /**
     *
     * @param exceptionCode
     * @param message
     * @param e
     */
    public MyException(ExceptionCode exceptionCode, String message, Throwable e) {
        super(message, e);
        this.status = exceptionCode.getValue();
    }

    /**
     *
     * @param e
     */
    public MyException(Throwable e){
        super(e);
        this.status = ExceptionCode.INNER_EXCEPTION.getValue();
        if (e instanceof SQLException) {
            this.status = ((SQLException) e).getErrorCode();
        }
        if (e instanceof MyException) {
            this.status = ((MyException) e).getStatus();
        }
    }


    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
