package com.chengzimm.CreationPattern.SingletonPattern;
//双检锁/双重校验锁（DCL，即 double-checked locking）
public class Singleton04 {

    public volatile static Singleton04 instance;

    private Singleton04(){

    }

    public static Singleton04 getInstance(){
        if (instance == null){
            synchronized (Singleton04.class){
                if (instance == null){
                    return instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}
