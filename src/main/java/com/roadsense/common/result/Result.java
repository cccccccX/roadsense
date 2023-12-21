package com.roadsense.common.result;

/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 21:34
 */
/**
 * 全局统一返回结果类
 */
public class Result {
    // 返回码
    private Integer code;
    // 返回消息
    private String message;
    // 返回数据
    private Object data;
    public Result(){}

    public Result(Integer code, Object data,String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    // 返回数据
    protected static Result build(Object data) {
        Result result = new Result();
        if (data != null)
            result.setData(data);
        return result;
    }
    public static Result build(Object body, Integer code, String message) {
        Result result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static Result build(Object body, CodeEnum codeEnum) {
        Result result = build(body);
        result.setCode(codeEnum.getCode());
        result.setMessage(codeEnum.getMessage());
        return result;
    }
    /**
     * 操作成功
     * @param data  baseCategory1List
     * @return
     */
    public static Result ok(Object data){
        Result result = build(data);
        return build(data, CodeEnum.SUCCESS);
    }
    public Result message(String msg){
        this.setMessage(msg);
        return this;
    }
    public Result code(Integer code){
        this.setCode(code);
        return this;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}