package org.black.lotus.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    private Selector selector;
    private ByteBuffer readBuffer;
    private ByteBuffer writeBuffer;

    public NIOServer() {
        // what will happen if overflow?
        readBuffer = ByteBuffer.allocate(1024);
        writeBuffer = ByteBuffer.allocate(1024);
    }

    public void start() throws IOException {
        // open socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // set to non block
        serverSocketChannel.configureBlocking(false);
        // bind address
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8009));

        // open get selector
        selector = Selector.open();
        // register to socket connection
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (!Thread.currentThread().isInterrupted()) {
            selector.select(); // select is a block call
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> eventIterator = selectionKeys.iterator();
            while (eventIterator.hasNext()) {
                SelectionKey eventKey = eventIterator.next();
                // when the key is invalid?
                if (eventKey.isValid()) {
                    continue;
                }

                if (eventKey.isAcceptable()) {
                    accept(eventKey);
                } else if (eventKey.isReadable()) {
                    read(eventKey);
                } else if (eventKey.isWritable()) {
                    write(eventKey);
                } else if (eventKey.isConnectable()) {
                    connectable(eventKey);
                }
                // event has been handled and should be removed
                eventIterator.remove();
            }
        }
    }

    private void connectable(SelectionKey eventKey) {

    }

    private void read(SelectionKey eventKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) eventKey.channel();

        // Clear out our read buffer so it's ready for new data
        this.readBuffer.clear();
        // Attempt to read off the channel
        int numRead;
        try {
            numRead = socketChannel.read(this.readBuffer);
        } catch (IOException e) {
            // The remote forcibly closed the connection, cancel
            // the selection key and close the channel.
            eventKey.cancel();
            socketChannel.close();
            return;
        }

        String str = new String(readBuffer.array(), 0, numRead);
        System.out.println(str);
        socketChannel.register(selector, SelectionKey.OP_WRITE);
    }

    private void write(SelectionKey eventKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel)eventKey.channel();
        writeBuffer.clear();
        writeBuffer.put("abc".getBytes(Charset.forName("UTF-8")));
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private void accept(SelectionKey eventKey) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) eventKey.channel();
        SocketChannel clientChannel = ssc.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("a new client connected "+clientChannel.getRemoteAddress());

    }

    public static void main(String... args) throws IOException {
        System.out.println("server started...");
        new NIOServer().start();
    }
}
