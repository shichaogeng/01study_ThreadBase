package com.gengsc.volatiletest;

/**
 * shichaogeng
 * 创建日期：2017/11/28
 * 创建时间: 20:29
 * 测试Volatile型变量的操作原子性
 */
public class VolatileThread implements Runnable {

    private volatile int a= 0;

    @Override
    public void run() {
//        synchronized (this){
            a=a+1;
            System.out.println(Thread.currentThread().getName()+"----"+a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a=a+1;
            System.out.println(Thread.currentThread().getName()+"----"+a);

//        }
    }

    public static void main(String[] args) {
        VolatileThread volatileThread = new VolatileThread();

        Thread t1 = new Thread(volatileThread);
        Thread t2 = new Thread(volatileThread);
        Thread t3 = new Thread(volatileThread);
        Thread t4 = new Thread(volatileThread);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
