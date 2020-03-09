package com.chengzimm.StructuralPattern.DecoratorPattern;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("绘制长方形");
    }
}
