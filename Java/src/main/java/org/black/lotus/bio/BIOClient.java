package org.black.lotus.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BIOClient {

    public static void main(String... args) throws IOException {
        List<Socket> socketSet = new ArrayList<>();
        try {
            for (int i = 0; i < 5000; ++i) {
                Socket s = new Socket("localhost", 9050);
                System.out.println(i + " has opened");
                socketSet.add(s);
            }

            Random random = new Random(System.currentTimeMillis());
            while (true) {
//            try {
//                //Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

                Socket socket = socketSet.get(random.nextInt(5000));
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("wo hahah".getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
