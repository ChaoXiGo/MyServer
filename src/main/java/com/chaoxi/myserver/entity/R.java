package com.chaoxi.myserver.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果通用R类
 * 服务端返回的数据都会封装成这个对象
 * @param <T>
 */
@Data
public class R<T> {

    // 编码: 1为成功,其它视为失败
    private Integer code;
    // 错误信息
    private String message;

    // 返回的数据
    private T data;


    // 返回动态数据
    private Map map = new HashMap();

    /**
     * 返回值对象的成功方法, code = 1为成功
     * @param object 返回值
     * @return
     * @param <T>
     */
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    /**
     * 返回值对象的错误方法, code = 0 为失败
     * @param object
     * @return
     * @param <T>
     */
    public static <T> R<T> error(String object){
        R<T> r = new R<>();
        r.message = object;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value){
        this.map.put(key,value);
        return this;
    }
}
