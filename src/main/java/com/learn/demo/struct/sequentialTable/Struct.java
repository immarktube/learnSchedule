package com.learn.demo.struct.sequentialTable;

/**
 * 此类为描写顺序表的结构
 */
public class Struct {

    static class DATA {
        String key;
        String name;
        int age;
    }

    /**
     * 顺序表
     */
    static class SLType{
        static final int MXALEN = 100;
        DATA[] ListData = new DATA[MXALEN+1];
        int ListLen;

        void SLInit(SLType SL){
            SL.ListLen = 0;
        }

        int SLLength(SLType SL){
            return (SL.ListLen);
        }

        int SLInsert(SLType SL,int n,DATA data){
            int i;
            if (SL.ListLen >= MXALEN){
                System.out.println("顺序表已满，不能插入节点！\n");
                return 0;
            }
            if (n<1 || n>SL.ListLen -1){
                System.out.println("插入元素序号错误，不能插入元素！\n");
                return 0;
            }
            for (i = SL.ListLen;i>=n;i--){
                SL.ListData[i+1] = SL.ListData[i];
            }
            SL.ListData[n] = data;
            SL.ListLen++;
            return 1;
        }

        int SLAdd(SLType SL,DATA data){
            if (SL.ListLen >= MXALEN){
                System.out.println("顺序表已满");
                return 0;
            }
            SL.ListData[++SL.ListLen] = data;
            return 1;
        }

        int SLDelete(SLType SL,int n){
            int i;
            if (n<1 || n>SL.ListLen+1){
                System.out.println("非法的元素位置，删除失败！\n");
                return 0;
            }
            for (i =n;i<SL.ListLen;i++){
                SL.ListData[i] = SL.ListData[i+1];
            }
            SL.ListLen--;
            return 1;
        }

        DATA SLFindByNum(SLType SL,int n){
            if (n<1 || n>SL.ListLen+1){
                System.out.println("非法的元素位置，查询失败！\n");
                return null;
            }
            return SL.ListData[n];
        }

        int SLFindByKey(SLType SL,String key){
            int i;
            for (i = 1;i<= SL.ListLen;i++){
                if (SL.ListData[i].key.compareTo(key) == 0){
                    return i;
                }
            }
            return 0;
        }

        int SLAll(SLType SL){
            int i;
            for (i =1;i<=SL.ListLen;i++){
                System.out.printf("(%s,%s,%d,) \n",SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
            }
            return 0;
        }

    }


}
