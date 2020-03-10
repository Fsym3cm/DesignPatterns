package com.chengzimm.BehavioralPattern.ChainOfResponsibilityPattern;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(){
        this.level = INFO;
        setNextLogger(null);
    }

    @Override
    protected void write(String message) {
        System.out.println("控制台日志：" + message);
    }
}
