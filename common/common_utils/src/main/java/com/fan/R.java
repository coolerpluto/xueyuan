package com.fan;


import io.swagger.models.auth.In;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    
    private Integer code;
    
    private Boolean success;
    
    private String message; 

    private Map<String, Object> data = new HashMap<String, Object>();
    
    private R(){}
    
    public static R ok(){
        R r = new R();
        r.setCode(ResultCode.SUCCESS);
        r.setSuccess(true);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setCode(ResultCode.ERROR);
        r.setSuccess(false);
        r.setMessage("失败");
        return r;
    }
    
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }
    
    public R data(String k, Object v){
        this.data.put(k,v);
        return this;
    }
    
    public R data(Map<String, Object> map){
        this.data = map;
        return this;
    }
    
}
