package com.chengzimm.BehavioralPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    //获得状态
    public int getState(){
        return state;
    }

    //设置状态
    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    //订阅
    public void attach(Observer observer){
        observers.add(observer);
    }

    //通知所有订阅的观察者
    public void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
