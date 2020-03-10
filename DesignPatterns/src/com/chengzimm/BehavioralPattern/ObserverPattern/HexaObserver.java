package com.chengzimm.BehavioralPattern.ObserverPattern;

public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("十六进制字符串：" + Integer.toHexString(subject.getState()));
    }
}
