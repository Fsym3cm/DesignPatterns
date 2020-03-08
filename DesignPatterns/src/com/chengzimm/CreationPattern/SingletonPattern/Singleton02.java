package com.chengzimm.CreationPattern.SingletonPattern;
//懒汉式，线程安全
public class Singleton02 {

    public static Singleton02 instance;

    private Singleton02(){

    }

    public static synchronized Singleton02 getInstance(){
        if (instance == null){
            return instance = new Singleton02();
        }
        return instance;
    }
}
