package com.learn.demo;

import io.lettuce.core.StrAlgoArgs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;

@SpringBootTest
public class TestNonBlockingNIO3 {

    @Test
    public void client(){
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));){
//            socketChannel.bind(new InetSocketAddress("127.0.0.1",9898));
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(LocalDateTime.now().toString().getBytes(StandardCharsets.UTF_8));
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void server(){
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();){
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(9898));

            Selector selector = Selector.open();

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if (next.isReadable()){
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = channel.read(byteBuffer)) != -1){
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(),0,len));
                            byteBuffer.clear();
                        }
                    } else if (next.isAcceptable()){
//                        若接收就绪，获取客户端链接
                        SocketChannel sChannel = serverSocketChannel.accept();
//                    要把客户端链接切换成非阻塞模式
                        sChannel.configureBlocking(false);
                        sChannel.register(selector,SelectionKey.OP_READ);
                    }
                }
                iterator.remove();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
