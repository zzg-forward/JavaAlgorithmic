package com.zzg.myThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * BlockingQueue
 * Java定义了阻塞队列的接口java.util.concurrent.BlockingQueue，阻塞队列的概念是，一个指定长度的队列，如果队列满了，添加新元素的操作会被阻塞等待，直到有空位为止。同样，当队列为空时候，请求队列元素的操作同样会阻塞等待，直到有可用元素为止。
 *
 * java.util.concurrent.BlockingQueue继承了java.util.Queue接口
 *
 * 阻塞队列还有更多实现类，用来满足各种复杂的需求：ArrayBlockingQueue, DelayQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue
 */

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue bqueue = new ArrayBlockingQueue(20);
        for (int i = 0;i < 30;i++) {
            try {
                bqueue.put(i);
                System.out.println("向阻塞队列中添加了元素:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序到此运行结束，即将退出----");
    }


    /**
     * 阻塞栈
     *
     * Java为阻塞栈定义了接口：java.util.concurrent.BlockingDeque
     */
    public static void testBlockingDeque() {
        BlockingDeque bDeque = new LinkedBlockingDeque(20);
        for (int i = 0; i < 30; i++) {
            //将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）。
            try {
                bDeque.putFirst(i);
                System.out.println("向阻塞栈中添加了元素:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序到此运行结束，即将退出----");
    }

}
