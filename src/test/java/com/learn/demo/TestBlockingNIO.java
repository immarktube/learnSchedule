package com.learn.demo;

import io.lettuce.core.StrAlgoArgs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@SpringBootTest
public class TestBlockingNIO {

    @Test
    public void client(){
        try(
            SocketChannel serverSocketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

            FileChannel fileChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                serverSocketChannel.write(byteBuffer);
                byteBuffer.clear();
            }

            int len = 0;
            while((len = serverSocketChannel.read(byteBuffer)) != -1){
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(),0,len));
                byteBuffer.clear();
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
    }


    @Test
    public void server(){
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
             FileChannel inChannel = FileChannel.open(Paths.get("2.png"),StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        ){
            serverSocketChannel.bind(new InetSocketAddress(9898));
            SocketChannel accept = serverSocketChannel.accept();
            ByteBuffer inBffer = ByteBuffer.allocate(1024);
            while(accept.read(inBffer) != -1){
                inBffer.flip();
                inChannel.write(inBffer);
                inBffer.clear();
            }

            inBffer.put("服务端接收数据成功！".getBytes(StandardCharsets.UTF_8));
            inBffer.flip();
            accept.write(inBffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
