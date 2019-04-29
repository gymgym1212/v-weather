package com.example.bigdata.nothing;

public class DoubleCheckLock {
    public volatile static DoubleCheckLock instance;

    private DoubleCheckLock() {}

    public static DoubleCheckLock getInstance() {
        if(instance!=null) {
            return instance;
        }

        synchronized (DoubleCheckLock.class) {
            if(null==instance) {
                instance = new DoubleCheckLock();
            }
        }
        return instance;

    }

    public static void main(String[] args) {

    }
}

