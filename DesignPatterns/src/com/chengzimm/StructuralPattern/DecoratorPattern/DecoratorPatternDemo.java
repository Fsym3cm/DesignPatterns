package com.chengzimm.StructuralPattern.DecoratorPattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        circle.draw();
        //前面的类型信息可以是Shape ShapeDecorator RedShapeDecorator其中任何一个
        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();

        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
    }
}
