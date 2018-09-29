package Test;

public class Test1 {
    public static void main(String[] args){
//        //实现多线程的第一种方式
//        Test2 t1 = new Test2();
//        t1.start();
//
//        //实现多线程的第二种方式
//        MyRunnable runnable = new MyRunnable();
//        Thread t2 = new Thread(runnable);
//        t2.start();
//
//
//        System.out.println("123");
        new MyThread().start();

    }
}

class Test2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("111");
    }
}


class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("这是实现多线程的第二种方式");
    }
}

class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i) % 10 == 0) {
                System.out.println("-------" + i);
            }
            System.out.print(i);
            try {
                Thread.sleep(1);
                System.out.print("    线程睡眠1毫秒！\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
