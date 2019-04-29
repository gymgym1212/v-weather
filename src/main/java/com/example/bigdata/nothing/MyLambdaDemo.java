package com.example.bigdata.nothing;

public class MyLambdaDemo {
    public static void main(String[] args) {
        Lambda lbd = ()-> System.out.println("hello");

        lbd.method1();
    }
}



class My implements Lambda {
    @Override
    public void method1() {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("terminal");
    }
}


interface Lambda {
    void method1();
}