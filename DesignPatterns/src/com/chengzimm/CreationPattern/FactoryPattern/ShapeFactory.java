package com.chengzimm.CreationPattern.FactoryPattern;

public class ShapeFactory {

    //定义一个 getShape 方法用于获取改形状的对象
    public Shape getShape(String shapeType){
        if (shapeType == "circle"){
            return new Circle();
        } else if (shapeType == "square"){
            return new Square();
        } else if (shapeType == "rectangle"){
            return new Rectangle();
        } else {
            return null;
        }
    }
}
