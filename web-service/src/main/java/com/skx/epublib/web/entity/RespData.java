package com.skx.epublib.web.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespData {
    //响应码
    private Integer code;
    //信息
    private String message;
    //返回数据
    private Object data;

    public static RespData OK(String msg, Object data) {
        return new RespData(200,msg,data);
    }

    public static RespData OK(Object data) {
        return new RespData(200,"OK",data);
    }

    public static RespData OK() {
        return new RespData(200,"OK",null);
    }

    public static RespData FAIL() {
        return new RespData(404,"Not Found!!!",null);
    }

    public static RespData FAIL(String msg) {
        return new RespData(404,msg,null);
    }

    public static RespData FAIL(String msg,Object data) {
        return new RespData(404,msg,data);
    }
}
