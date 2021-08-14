package com.learn.demo.test;

import java.util.*;

class Solution extends AbstractClassDemo {
    /**
     * 输入：tasks = [[1,2],[2,4],[3,2],[4,1]]
     * 输出：[0,2,3,1]
     * 其中 tasks[i] = [enqueueTimei, processingTimei]
     * 意味着第 i 项任务将会于 enqueueTimei 时进入任务队列，
     * 需要 processingTimei 的时长完成执行。
     *
     * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
     * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
     * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
     * CPU 可以在完成一项任务后，立即开始执行一项新任务。
     *
     * tasks.length == n
     * 1 <= n <= 105
     * 1 <= enqueueTimei, processingTimei <= 109
     * @param tasks
     * @return
     */
    public int[] getOrder(int[][] tasks) {
        int index = 0;

        HashMap<int[],Integer> xiabiao = new HashMap<>();
        Arrays.sort(tasks);
        List list = new ArrayList<Integer>();
        // HashSet
        for (int[] s : tasks){
            xiabiao.put(s,index);
            // time.
            index++;
        }




        return null;
    }

    @Override
    public void testAbstract() {
        super.testAbstract();
    }
}