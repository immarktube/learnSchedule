package com.learn.demo;

import io.lettuce.core.StrAlgoArgs;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;

public class TestNonBlockingNIO {

    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

//        切换非阻塞模式
        socketChannel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(LocalDateTime.now().toString().getBytes(StandardCharsets.UTF_8));

        byteBuffer.flip();

        socketChannel.write(byteBuffer);

        byteBuffer.clear();

        socketChannel.close();

    }


    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        ssChannel.configureBlocking(false);

        ssChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

//        轮询式的获取选择器上已经"准备就绪"的事件
        while(selector.select() > 0){
//            获取当前选择器中所有注册的选择键（已就绪的监听事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

//            迭代获取
            while (it.hasNext()){
//                获取准备就绪的事件
                SelectionKey sk = it.next();
//                判断具体是什么事件就绪
                if (sk.isAcceptable()){
//                    若接收就绪，获取客户端链接
                    SocketChannel sChannel = ssChannel.accept();
//                    要把客户端链接切换成非阻塞模式
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
//                    若读取就绪，则先获取当前选择器读就绪状态的通道
                    SocketChannel schannel = (SocketChannel) sk.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = schannel.read(buf)) != -1){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
            }
            it.remove();
        }
    }
}
