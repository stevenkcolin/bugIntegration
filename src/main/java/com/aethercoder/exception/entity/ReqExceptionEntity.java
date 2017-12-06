package com.aethercoder.exception.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Guo Feiyan on 2017/8/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqExceptionEntity {

    private int errorCode;
    private Object data;
    private String message;
    private StackTraceElement[] stackTraceElements;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("cause")
    public StackTraceElement[] getStackTraceElements() {
        return stackTraceElements;
    }

    public void setStackTraceElements(StackTraceElement[] stackTraceElements) {
        this.stackTraceElements = stackTraceElements;
    }

    public static ReqExceptionEntity bulid(ErrorCode errorCode, String msg) {
        ReqExceptionEntity r = new ReqExceptionEntity();
        r.message = msg;
        r.errorCode = errorCode.getErrorCode();
        return r;

    }

    public static ReqExceptionEntity bulid(String msg, StackTraceElement[] stackTraceElements) {
        ReqExceptionEntity r = new ReqExceptionEntity();
        r.message = msg;
        r.setStackTraceElements(stackTraceElements);
        return r;

    }

    public enum ErrorCode {
        INCORRECT_PARAM(-1);

        private final int errorCode;

        ErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

}
