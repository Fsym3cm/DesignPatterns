package com.chengzimm.CreationPattern.AbstractFactoryPattern;

public class ColorFactory extends AbstractFactory {


    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    //使用 ColorFactory 继承 AbstractFactory，得到 color 信息
    @Override
    public Color getColor(String colorType) {
        if (colorType == "red"){
            return new Red();
        } else if (colorType == "green"){
            return new Green();
        } else if (colorType == "blue"){
            return new Blue();
        }else {
            return null;
        }
    }
}
