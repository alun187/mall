package com.cuidl.mall.common.vo;

import com.cuidl.mall.common.enmus.BusinessCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {


    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 结果对象
     */
    private T result;

    public static <T> Result<T> success(){
        return new Result<>(true,"success", BusinessCodeEnum.DEFAULT_SUCCESS.getCode(),null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(true,"success", BusinessCodeEnum.DEFAULT_SUCCESS.getCode(),data);
    }

    public static <T> Result<T> fail(Integer code, String message){
        return new Result<>(true,message,code,null);
    }

    public static <T> Result<T> fail(){
        return new Result<>(true,BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg(),BusinessCodeEnum.DEFAULT_SYS_ERROR.getCode(),null);
    }
}
