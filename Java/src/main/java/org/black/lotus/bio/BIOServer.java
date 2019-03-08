package org.black.lotus.bio;

import org.black.lotus.marker.Important;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

@Important
public class BIOServer {

    public static void main(String... args) throws IOException {
        try {
            ExecutorService es = new ThreadPoolExecutor(5000, 5000,
                    0L, TimeUnit.MILLISECONDS,
                    // 这里的queue capacity是关键,如果要是QUEUE没有满,那么任务始终会先缓存在QUEUE里,而ABORTPOLICY不会被触动.
                    new LinkedBlockingQueue<Runnable>(200), new ThreadPoolExecutor.AbortPolicy());
            ServerSocket serverSocket = new ServerSocket(9050);
            while (true) {
                try {
                    // 阻塞式的编程模型,阻塞在ACCEPT这里,知道新连接连上.连上后,SOCKET是个新对象.
                    Socket socket = serverSocket.accept();
                    System.out.println("coming");
                    es.submit(new Handler(socket));
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    static class Handler implements Runnable {
        Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    InputStream inputStream = socket.getInputStream();
                    // 这里的SOCKET READ会阻塞在这里. 这种阻塞式的模型会带来挺大问题. 因为如果是长连接这个线程是总要开着的
                    // 那么数千个连接可能就会造成溢出.
                    int read = inputStream.read();
                    while (read != -1) {
                        byte[] res = new byte[read];
                        read = inputStream.read(res);
                        System.out.println(Thread.currentThread().getName()
                                + " " + new java.lang.String(res)
                                + socket.getRemoteSocketAddress());
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
