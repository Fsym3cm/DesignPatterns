package com.chengzimm.StructuralPattern.ProxyPattern;

public class ProxyPatternDemo {
    public static void main(String[] args) {

        Image image = new ProxyImage("123.jpg");
        image.display();
        //如果有这个对象则不会重新加载。
        image.display();
    }
}
