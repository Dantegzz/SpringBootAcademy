package com.dann97.springboot.bean.implementation;

import com.dann97.springboot.bean.MyBean;

public class MyBeanImpl implements MyBean {

    @Override
    public String hello() {
        return "Hello from my BeanImplementation";
    }
}
