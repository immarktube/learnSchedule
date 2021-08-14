package com.learn.demo.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

public class TestChannel1 {

    public static void main(String[] args)  {
        try (FileChannel fileChannel = FileChannel.open(Paths.get("ss.jpeg"),StandardOpenOption.READ);
             SeekableByteChannel ss = Files.newByteChannel(Paths.get("ss"),StandardOpenOption.CREATE);
             ){
            System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

//            设置通道的操作权限
            Set<OpenOption> openOptions = new HashSet<>();
            openOptions.add(StandardOpenOption.CREATE_NEW);
            openOptions.add(StandardOpenOption.WRITE);
            openOptions.add(StandardOpenOption.READ);

//           设置文件操作权限
            Set<PosixFilePermission> set = new HashSet<>();
            set.add(PosixFilePermission.OWNER_READ);
            set.add(PosixFilePermission.OWNER_WRITE);

            set.add(PosixFilePermission.OWNER_EXECUTE);
            int i = 0;
            FileChannel fileChannel1 = FileChannel.open(Paths.get("aa.jpeg"),openOptions, PosixFilePermissions.asFileAttribute(set));
            while (fileChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                fileChannel1.write(byteBuffer);
                byteBuffer.clear();
                i++;
            }
            fileChannel1.close();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
