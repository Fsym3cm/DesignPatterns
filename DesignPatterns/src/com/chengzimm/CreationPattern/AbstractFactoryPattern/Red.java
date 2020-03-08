package com.chengzimm.CreationPattern.AbstractFactoryPattern;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("填满红色");
    }
}
