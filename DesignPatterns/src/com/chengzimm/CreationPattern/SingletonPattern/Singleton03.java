package com.chengzimm.CreationPattern.SingletonPattern;
//饿汉式
public class Singleton03 {

    public static Singleton03 instance = new Singleton03();

    private Singleton03(){

    }

    public static Singleton03 getInstance(){
        return instance;
    }
}
