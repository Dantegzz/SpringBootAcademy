package com.dann97.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class MyComponentBean implements MyComponent {
    @Override
    public void printSomething() {
        System.out.println("Printing out from MyComponentBean");
    }
}
