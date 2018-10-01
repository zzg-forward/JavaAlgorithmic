package com.zzg.myThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java多线程（十六）—–条件变量
 *
 * 条件变量都实现了java.util.concurrent.locks.Condition接口，条件变量的实例化是通过一个Lock对象上调用newCondition()方法来获取的，这样，条件就和一个锁对象绑定起来了。因此，Java中的条件变量只能和锁配合使用，来控制并发程序访问竞争资源的安全。
 *
 * 条件变量的出现是为了更精细控制线程等待与唤醒，在Java5之前，线程的等待与唤醒依靠的是Object对象的wait()和notify()/notifyAll()方法，这样的处理不够精细。
 *
 * 而在Java5中，一个锁可以有多个条件，每个条件上可以有多个线程等待，通过调用await()方法，可以让线程在该条件下等待。当调用signalAll()方法，又可以唤醒该条件下的等待的线程。
 */

public class ConditionTest {
    public static void main(String[] args) {
        MyNormalCount myCount = new MyNormalCount("95599200901215522", 10000);
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread t1 = new SaveThread("张三", myCount, 2000);
        Thread t2 = new SaveThread("李四", myCount, 3600);
        Thread t3 = new DrawThread("王五", myCount, 2700);
        Thread t4 = new SaveThread("老张", myCount, 600);
        Thread t5 = new DrawThread("老牛", myCount, 1300);
        Thread t6 = new DrawThread("胖子", myCount, 800);
        //执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        //关闭线程池
        pool.shutdown();
    }
}


class MyNormalCount {
    private String oid;                         //账号
    private int cash;                             //账户余额
    private Lock lock = new ReentrantLock();                //账户锁
    private Condition _save = lock.newCondition();    //存款条件
    private Condition _draw = lock.newCondition();    //取款条件

    MyNormalCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }

    /**
     * 存款
     *
     * @param x        操作金额
     * @param name 操作人
     */
    public void saving(int x, String name) {
        lock.lock();

        if (x > 0) {
            cash += x;
            System.out.println(name + "存款" + x + "，当前余额为" + cash);
        }
        _draw.signalAll();   //唤醒所有等待的线程
        lock.unlock();
    }

    /**
     * 取款
     *
     * @param x        操作金额
     * @param name 操作人
     */
    public void drawing(int x, String name) {
        lock.lock();
        try {
            if (cash - x < 0) {
                _draw.await();          //阻塞取款操作
            } else {
                cash -= x;              //取款
                System.out.println(name + "取款" + x + "，当前余额为" + cash);
            }
            _save.signalAll();             //唤醒所有存款操作
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


/**
 * 取款线程类
 */
class DrawThread extends Thread {
    private String name;                //操作人
    private MyNormalCount myCount;        //账户
    private int x;                            //存款金额

    DrawThread(String name, MyNormalCount myCount, int x) {
        this.name = name;
        this.myCount = myCount;
        this.x = x;
    }

    @Override
    public void run() {
        super.run();
        myCount.drawing(x, name);
    }
}


/**
 * 存款线程类
 */
class SaveThread extends Thread {
    private String name;                //操作人
    private MyNormalCount myCount;        //账户
    private int x;                            //存款金额

    SaveThread(String name, MyNormalCount myCount, int x) {
        this.name = name;
        this.myCount = myCount;
        this.x = x;
    }

    @Override
    public void run() {
        super.run();
        myCount.saving(x, name);
    }
}

