package com.learn.demo.interview.algorithm;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2022/5/24 15:47
 **/
public class FirstBadVersion {

    private int badVersion = 1;
    private int[] versionList = {1,2,3,4,5,6,7,8,9,10};

    public int firstBadVersion(int n) {

        return 1;
    }

    private boolean isBadVersion(int i){
        return i > 3;
    }

    private void binarySearch(int[] arr,int target, int targetIndex){
        int num = 0;
        int low = 0;
        int hight = arr.length;
        while(hight - low > 1){
            num++;
            System.out.println(num+"次");
            int midd = (hight + low) / 2;
            int itemvalue = arr[midd];
            if (itemvalue > target){
                hight = midd - 1;
            } else if (itemvalue < target){
                low = midd + 1;
            }else {
                return;
            }
        }
    }
}
