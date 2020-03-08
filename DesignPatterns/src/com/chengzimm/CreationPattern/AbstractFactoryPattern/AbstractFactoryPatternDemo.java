package com.chengzimm.CreationPattern.AbstractFactoryPattern;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //不使用静态方法
        FactoryProducer factoryProducer = new FactoryProducer();
        Shape shape1 = factoryProducer.getFactory("shape").getShape("circle");
        shape1.draw();

        //使用静态方法
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape2 = shapeFactory.getShape("square");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("rectangle");
        shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("red");
        color1.fill();

        Color color2 = colorFactory.getColor("green");
        color2.fill();

        Color color3 = colorFactory.getColor("blue");
        color3.fill();
    }
}
