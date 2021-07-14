package com.dann97.springboot.component;

import org.springframework.stereotype.Component;

@Component("AnyName")
public class MyComponentBeanTwo implements MyComponent {
    @Override
    public void printSomething() {
        System.out.println("Printing from MyComponentBeanTwo");
    }
}
