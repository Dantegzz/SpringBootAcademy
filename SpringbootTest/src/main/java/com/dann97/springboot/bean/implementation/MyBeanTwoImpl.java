package com.dann97.springboot.bean.implementation;

import com.dann97.springboot.bean.MyBean;

public class MyBeanTwoImpl implements MyBean {

    private String name;
    private String randomValue;

    public MyBeanTwoImpl(String name, String randomValue) {
        this.name = name;
        this.randomValue = randomValue;
    }

    @Override
    public String hello() {
        return "Hello from my MyBeanTwoImpl with name: " + name + " random value: "+randomValue;
    }
}
