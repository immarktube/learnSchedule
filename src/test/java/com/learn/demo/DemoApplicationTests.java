package com.learn.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.*;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(SpringBootVersion.getVersion()+"==="+ SpringVersion.getVersion());
    }

    @Test
    public void test1(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("------------akkicate()------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println(PosixFilePermission.GROUP_READ);
    }

    @Test
    public  void test2() throws CharacterCodingException {
        Map<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        Iterator<Map.Entry<String, Charset>> iterator = stringCharsetSortedMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Charset> entry = iterator.next();
            System.out.println(entry.getKey()+" : : "+entry.getValue());
        }
//        for (Map.Entry<String,Charset> entry : entries){
//            System.out.println(entry.getKey()+" : : "+entry.getValue());
//        }

        CharBuffer cbuf = CharBuffer.allocate(1024);
        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_8.newEncoder();
        cbuf.put("hello world!");
        cbuf.flip();
        ByteBuffer byteBuffer = charsetEncoder.encode(cbuf);
        for (int i = 0; i < 12; i++) {
            System.out.println(byteBuffer.get());
        }
        System.out.println("===========================================");
        byteBuffer.flip();
        CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
        System.out.println(charBuffer.toString());
    }

    @Test
    public void test3(){
        try (FileChannel fileChannel = FileChannel.open(Paths.get("pom.xml"), StandardOpenOption.READ,StandardOpenOption.WRITE);){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Set<OpenOption> openOptions = new HashSet<>();
            openOptions.add(StandardOpenOption.WRITE);
            openOptions.add(StandardOpenOption.READ);
            openOptions.add(StandardOpenOption.CREATE);

            Set<PosixFilePermission> posixFilePermissions = new HashSet<>();
            posixFilePermissions.add(PosixFilePermission.OWNER_EXECUTE);
            posixFilePermissions.add(PosixFilePermission.OWNER_WRITE);
            posixFilePermissions.add(PosixFilePermission.OWNER_READ);

            FileChannel newChannel = FileChannel.open(Paths.get("pom111.xml"),openOptions, PosixFilePermissions.asFileAttribute(posixFilePermissions));
            while (fileChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                newChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
