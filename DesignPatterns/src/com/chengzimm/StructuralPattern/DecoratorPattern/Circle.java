package com.chengzimm.StructuralPattern.DecoratorPattern;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}
