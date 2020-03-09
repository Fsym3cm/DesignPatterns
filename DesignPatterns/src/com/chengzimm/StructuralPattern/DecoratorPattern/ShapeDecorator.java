package com.chengzimm.StructuralPattern.DecoratorPattern;

public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;
    //使用构造函数将变量实例化
    public ShapeDecorator(Shape decoratedShape){
        //this调用自身类的构造函数
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
