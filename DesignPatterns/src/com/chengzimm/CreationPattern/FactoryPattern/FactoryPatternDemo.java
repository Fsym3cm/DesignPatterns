package com.chengzimm.CreationPattern.FactoryPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        //通过工厂方法获取其形状
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("square");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("rectangle");
        shape3.draw();
    }
}
