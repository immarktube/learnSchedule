package com.learn.demo.struct.sequentialTable;
import com.learn.demo.struct.sequentialTable.Struct.*;

import java.util.Scanner;

public class P2_1{
    public static void main(String[] args) {
        int i;
        SLType SL = new SLType();
        DATA pdata;
        String key;
        System.out.println("顺序表操作演示！\n");
        SL.SLInit(SL);
        System.out.println("初始化完成！");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("输入添加的节点（学号，年龄，名字）：");
            DATA data = new DATA();
            data.key = input.next();
            data.name = input.next();
            data.age = input.nextInt();

            if (data.age != 0){
                if (SL.SLAdd(SL,data)==0){
                    break;
                }
            }else break;
        }while (true);
        System.out.println("\n顺序表的结点顺序为:\n");
        SL.SLAll(SL);
        System.out.println("\n要取出的结点序号为：");
        i = input.nextInt();
        pdata = SL.SLFindByNum(SL,i);
        if (pdata!= null){
            System.out.printf("第%d个结点为:(%s,%s,%d) \n",i,pdata.key,pdata.name
            ,pdata.age);
        }

        System.out.println("\n要查找的结点关键字为：");
        key = input.next();
        i = SL.SLFindByKey(SL,key);
        pdata = SL.SLFindByNum(SL,i);
        if (pdata != null){
            System.out.printf("第%d个结点为:(%s,%s,%d) \n",i,pdata.key,pdata.name
                    ,pdata.age);
        }
    }
}