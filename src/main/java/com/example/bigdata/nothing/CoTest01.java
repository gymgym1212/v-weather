package com.example.bigdata.nothing;

public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

class Producer extends Thread {
    private SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("生产-->第" + i + "个馒头");
            container.push(new Steamedbun(i));
        }
    }
}


class Consumer extends Thread {
    private SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("消费-->第" + container.pop().id + "个馒头");
        }

    }
}




class SynContainer {
    Steamedbun[] buns = new Steamedbun[10];
    int count;

    public synchronized void push(Steamedbun bun) {
        if(count==buns.length) {
            try {
                this.wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count++] = bun;
        this.notify();
    }

    public synchronized Steamedbun pop() {
        if(count==0) {
            try {
                this.wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        Steamedbun bun = buns[--count];
        this.notify();
        return bun;
    }

}


class Steamedbun {
    int id;
    public Steamedbun(int id) {
        this.id = id;
    }
}

