package com.chengzimm.BehavioralPattern.ChainOfResponsibilityPattern;

public class ChainPatternDemo {
    public static void main(String[] args) {

        AbstractLogger errorLogger = new ErrorLogger();

        errorLogger.logMessage(1, "控制台信息");
        System.out.println();
        errorLogger.logMessage(2, "测试信息");
        System.out.println();
        errorLogger.logMessage(3, "错误信息");
    }
}
