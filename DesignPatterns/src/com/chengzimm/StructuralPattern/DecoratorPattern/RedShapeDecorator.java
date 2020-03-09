package com.chengzimm.StructuralPattern.DecoratorPattern;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        //调用父类的构造方法
        super(decoratedShape);
    }

    @Override
    public void draw() {
        //当将decoratedShape设置为private时，可以通过super来调用draw方法
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("填充红色");
    }
}
