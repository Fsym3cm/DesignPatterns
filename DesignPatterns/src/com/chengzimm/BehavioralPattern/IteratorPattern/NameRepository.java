package com.chengzimm.BehavioralPattern.IteratorPattern;

public class NameRepository implements Container {

    public String names[] = {"张三", "李四", "王五", "赵六"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;
        @Override
        public boolean hasNext() {
           if (index < names.length){
               return true;
           }
           return false;
        }

        @Override
        public Object next() {
            if (hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
