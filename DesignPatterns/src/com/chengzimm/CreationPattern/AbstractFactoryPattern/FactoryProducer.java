package com.chengzimm.CreationPattern.AbstractFactoryPattern;

public class FactoryProducer {

    //创建一个工厂创造器/生成器，通过传递的信息来获取工厂
    public static AbstractFactory getFactory(String factory){
        if (factory == "shape"){
            return new ShapeFactory();
        } else if (factory == "color"){
            return new ColorFactory();
        } else {
            return null;
        }
    }
}
