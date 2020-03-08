package com.chengzimm.CreationPattern.AbstractFactoryPattern;

public class ShapeFactory extends AbstractFactory{

    //使用 ShapeFactory 继承 AbstractFactory，得到 shape 信息
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == "circle"){
            return new Circle();
        } else if (shapeType == "square"){
            return new Square();
        } else if (shapeType == "rectangle"){
            return new Renctangle();
        }else {
            return null;
        }
    }

    //颜色信息返回 null
    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
