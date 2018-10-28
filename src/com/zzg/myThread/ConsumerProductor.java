package com.zzg.myThread;

/**
 * object wait/notify（synchronized）
 * 消息通知机制实现生产者-消费者模式
 */

public class ConsumerProductor {
    private final static String lockObject = "";
    private static boolean isWait = true;

    public static void main(String[] args) {
        WaitThread waitThread = new WaitThread(lockObject);
        NotifyThread notifyThread = new NotifyThread(lockObject);
        notifyThread.start();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitThread.start();
    }

    static class WaitThread extends Thread {
        private final String lock;

        public WaitThread(String lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try{
                    while (isWait) {
                        System.out.println(Thread.currentThread().getName() + " 进去代码块");
                        System.out.println(Thread.currentThread().getName() + "开始wait");
                        lock.wait();  //阻塞操作
                        System.out.println(Thread.currentThread().getName() + "   结束wait");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class NotifyThread extends Thread {
        private final String lock;

        public NotifyThread (String lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "  进去代码块");
                System.out.println(Thread.currentThread().getName() + "  开始notify");
                lock.notifyAll();
                isWait = false;
                System.out.println(Thread.currentThread().getName() + "   结束notify");
            }
        }
    }


}
