package com.chengzimm.BehavioralPattern.IteratorPattern;

public interface Iterator {

    //判断是否还有下一个值
    public boolean hasNext();
    //返回下一个值的内容
    public Object next();
}
