package com.chengzimm.BehavioralPattern.IteratorPattern;

public class IteratorPatternDemo {
    public static void main(String[] args) {

        NameRepository nameRepository = new NameRepository();
        Iterator iter = nameRepository.getIterator();

        while (iter.hasNext()){
            String name = (String)iter.next();
            System.out.println(name);
        }
    }
}
