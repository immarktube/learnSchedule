package com.learn.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

@SpringBootTest
public class TestNonBlockingNIO2 {

    @Test
    public void send() throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str = scanner.next();

            byteBuffer.put((LocalDateTime.now().toString() + ":\n" + str).getBytes(StandardCharsets.UTF_8));

            byteBuffer.flip();
            dc.send(byteBuffer,new InetSocketAddress("127.0.0.1",9898));

            byteBuffer.clear();
        }

        dc.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        dc.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk = it.next();
                if (sk.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    dc.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new java.lang.String(byteBuffer.array(),0,byteBuffer.limit()));
                    byteBuffer.clear();
                }
            }
            it.remove();
        }


    }
}
