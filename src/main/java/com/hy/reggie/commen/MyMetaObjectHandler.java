package com.hy.reggie.commen;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充---insert...");
        log.info(metaObject.toString());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        //自定义工具类过去当前登录用户的id
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());

    }
    /**
     * 更新时自动填充
     * @param metaObject
     */
    /***
     * 什么是ThreadLocal?
         * ThreadLocal:并不是一个Thread,而是Thread的局部变量。当使用ThreadLocal维护变量时，ThreadLocal为每个使用该
         * 变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
         * ThreadLocal为每个线程提供单独一份存储空间，具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不
         * 能访问。
     * ThreadLocal常用方法：
         * public void set(T value) 设置当前线程的线程局部变量的值
         * public T get() 返回当前线程所对应的线程局部变量的值
     * 我们可以在LoginCheckFilter的doFilter方法中获取当前登录用户id,并调用ThreadLocal的set方法来设置当前线程的线
     * 程局部变量的值（用户id),然后在MyMetaObjectHandler的updateFill方法中调用ThreadLocal的get方法来获得当前
     * 线程所对应的线程局部变量的值（用户id)。
     * */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充---update...");
        log.info(metaObject.toString());

        long id = Thread.currentThread().getId();
        log.info("线程ID：{}", id);

        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}
