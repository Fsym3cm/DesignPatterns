package com.chengzimm.CreationPattern.SingletonPattern;
//懒汉式，线程不安全
public class Singleton01 {

    public static Singleton01 instance;

    private Singleton01(){

    }

    public static Singleton01 getInstance(){
        if (instance == null){
            return instance = new Singleton01();
        }
        return instance;
    }
}
