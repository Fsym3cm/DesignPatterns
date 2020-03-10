package com.chengzimm.BehavioralPattern.ObserverPattern;

public class OctalObserver extends Observer {

    public OctalObserver (Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("八进制字符串：" + Integer.toOctalString(subject.getState()));
    }
}
