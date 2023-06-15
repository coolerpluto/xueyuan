package com.fan.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        this.setFieldValByName("gmtCreate",date, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date();
        this.setFieldValByName("gmtModified",date, metaObject);
    }
}
