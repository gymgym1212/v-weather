package com.example.bigdata.nothing;

public class DeadLockDemo {
    public static void main(String[] args) {
        new MakeUp("girl_A", 1).start();
        new MakeUp("girl_B", 2).start();

    }
}



class MakeUp extends Thread {
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    String girl;
    int choice;

    public MakeUp(String girl, int choice) {
        this.girl = girl;
        this.choice = choice;
    }

    @Override
    public void run() {
        if(this.choice==1) {
            synchronized (mirror) {
                System.out.println(girl + " is using mirror");
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }

            synchronized (lipStick) {
                System.out.println(girl + " is using lipstick");
            }



        }else{
            synchronized (lipStick) {
                System.out.println(girl + " is using lipstick");
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }

            synchronized (mirror) {
                System.out.println(girl + " is using mirror");

            }
        }
    }
}

class LipStick{

}

class Mirror {

}
