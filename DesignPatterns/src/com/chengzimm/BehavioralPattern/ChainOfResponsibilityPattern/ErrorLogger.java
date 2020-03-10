package com.chengzimm.BehavioralPattern.ChainOfResponsibilityPattern;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(){
        this.level = ERROR;
        setNextLogger(new FileLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("错误日志：" + message);
    }
}
