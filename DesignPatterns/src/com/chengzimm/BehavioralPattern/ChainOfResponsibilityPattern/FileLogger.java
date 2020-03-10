package com.chengzimm.BehavioralPattern.ChainOfResponsibilityPattern;

public class FileLogger extends AbstractLogger {

    public FileLogger(){
        this.level = DEBUG;
        setNextLogger(new ConsoleLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("文件日志：" + message);
    }
}
