package com.zzg.myThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 java多线程（十三）—–信号量
 
 * 从结果可以看出，信号量仅仅是对池资源进行监控，但不保证线程的安全，因此，在使用时候，应该自己控制线程的安全访问池资源。
 */

public class SemaphoreTest {
    public static void main(String[] args) {
        MyPool myPool = new MyPool(20);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        MyThread t1 = new MyThread("任务A", myPool, 3);
        MyThread t2 = new MyThread("任务B", myPool, 12);
        MyThread t3 = new MyThread("任务C", myPool, 7);
        //在线程池中执行任务
        threadPool.execute(t1);
        threadPool.execute(t2);
        threadPool.execute(t3);
        //关闭池
        threadPool.shutdown();
    }



}


class MyPool {
    private Semaphore sp;  //池相关的信号量

    MyPool(int size) {
        this.sp = new Semaphore(size);
    }

    public Semaphore getSp() {
        return sp;
    }

    public void setSp(Semaphore sp) {
        this.sp = sp;
    }

}


class MyThread extends Thread {
    private String threadname;            //线程的名称
    private MyPool pool;                        //自定义池
    private int x;                                    //申请信号量的大小

    MyThread(String threadname, MyPool pool, int x) {
        this.threadname = threadname;
        this.pool = pool;
        this.x = x;
    }

    @Override
    public void run() {
        super.run();
        try {
            //从此信号量获取给定数目的许可
            pool.getSp().acquire();
            //todo：也许这里可以做更复杂的业务
            System.out.println(threadname + "成功获取了" + x + "个许可！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放给定数目的许可，将其返回到信号量。
            pool.getSp().release();
            System.out.println(threadname + "释放了" + x + "个许可！");
        }
    }
}
