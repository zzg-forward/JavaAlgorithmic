package com.zzg.myThread;

/**
 * 简单的消费者与生产者模型
 */

public class Test {

    public static void main(String[] args) {
        Godow godow = new Godow(30);
        Consumer c1 = new Consumer(50, godow);
        Consumer c2 = new Consumer(20, godow);
        Consumer c3 = new Consumer(30, godow);
        Producer p1 = new Producer(10, godow);
        Producer p2 = new Producer(10, godow);
        Producer p3 = new Producer(10, godow);
        Producer p4 = new Producer(10, godow);
        Producer p5 = new Producer(10, godow);
        Producer p6 = new Producer(10, godow);
        Producer p7 = new Producer(10, godow);

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}


/**
 * 仓储
 */
class Godow {
    public static final int max_size = 100;  //最大库存量
    public int curnum;  //当前库存量

    Godow() {

    }

    Godow(int curnum) {
        this.curnum = curnum;
    }

    /**
     * 生产指定数量的产品
     *
     * @param neednum
     */
    public synchronized void produce(int neednum) {
        while (neednum + curnum > max_size) {
            System.out.println("need to produce count is: " + neednum + " ,超过剩余库存量： " + (max_size - curnum) + " ,暂时不能执行生产任务！");
            try {
                //当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //满足生产条件，则进行生产，
        curnum += neednum;
        System.out.println("已经生产了 " + neednum + " 个产品，现在仓储量为： " + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }

    /**
     * 消费指定数量的产品
     * @param neednum
     */
    public synchronized void consume(int neednum) {
        //测试是否可消费
        while (curnum < neednum) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        curnum -= neednum;
        System.out.println("已经消费了 " + neednum + " 个产品，现仓储量为 " + curnum);
        notifyAll();
    }

}


/**
 * 生产者
 */
class Producer extends Thread {
    private int neednum;  //生产产品的数量
    private Godow godow;  //仓库

    Producer(int neednum, Godow godow) {
        this.neednum = neednum;
        this.godow = godow;
    }

    @Override
    public void run() {
        godow.produce(neednum);
    }
}


class Consumer extends Thread {
    private int neednum;  //生产产品的数量
    private Godow godow;

    Consumer(int neednum, Godow godow) {
        this.neednum = neednum;
        this.godow = godow;
    }

    @Override
    public void run() {
        godow.consume(neednum);
    }
}














