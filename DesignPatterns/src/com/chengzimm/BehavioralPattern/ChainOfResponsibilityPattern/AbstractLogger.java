package com.chengzimm.BehavioralPattern.ChainOfResponsibilityPattern;

public abstract class AbstractLogger {

    protected static int INFO = 1;
    protected static int DEBUG = 2;
    protected static int ERROR = 3;

    protected int level;
    //责任链中的下一个元素
    private AbstractLogger nextLogger;

    //设置责任链中下一个调用哪个接收者
    protected void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        //当level小于等于传入的level时才打印
        if (this.level <= level){
            write(message);
        }
        //如果责任链中的下一个元素不为空，则调用logMessage进行打印
        if (nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}
