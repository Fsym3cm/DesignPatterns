package com.chengzimm.StructuralPattern.ProxyPattern;

public class RealImage implements Image {

    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("展示 " + fileName);
    }

    public void loadFromDisk(String fileName){
        System.out.println("加载 " + fileName);
    }
}
