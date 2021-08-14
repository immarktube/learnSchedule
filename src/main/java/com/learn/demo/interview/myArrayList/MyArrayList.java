package com.learn.demo.interview.myArrayList;

public class MyArrayList<E>  {

    private Object[] data = null;
    private int capacity;
    private int current;

    private void validateCapacity(){
        if (current == capacity){
            capacity *= 2;
         Object[] newData = new Object[capacity];
         for (int index = 0;index < current;++index){
             newData[index] = data[index];
         }
         data = newData;
        }
    }

    private void validateIndex(int index){
        if (index < 0 || index > current){
            throw new RuntimeException("无效的下标，请重新输入");
        }
    }

    public boolean add(E e){
        validateCapacity();
        data[current] = e;
        ++current;
        return true;
    }

    public boolean remove(int index){
        validateIndex(index);
        for(;index < current -1;++index){
            data[index] = data[index+1];
        }
        data[current -1 ] = null;
        --current;
        return true;
    }

    public E get(int index){
        validateIndex(index);
        return (E)data[index];
    }

    /**
     * 在指定位置插入指定元素
     * @param index 待插入的位置
     * @param e 待插入的元素
     * @return
     */
    public boolean insert(int index, E e) {
        validateIndex(index);
        validateCapacity();
        for (int temp = current; temp > index; --temp) {
            data[temp] = data[temp - 1];
        }
        data[index] = e;
        return true;
    }

}
