package com.gengsc.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * shichaogeng
 * 创建日期：2017/11/26
 * 创建时间: 21:00
 * 如何覆盖线程的interrupt() 方法
 */
public class OverrideInterrupt extends Thread {
    private final Socket socket;
    private final InputStream in;

    public OverrideInterrupt(Socket socket, InputStream in) {
        this.socket = socket;
        this.in = in;
    }

    private void t(){
    }

    @Override
    public void interrupt() {
        try {
            //关闭底层的套接字
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            //.....
        }finally {
            //同时中断线程
            super.interrupt();
        }

    }
}
