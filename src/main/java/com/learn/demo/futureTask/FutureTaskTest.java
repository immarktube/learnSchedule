package com.learn.demo.futureTask;

import java.util.concurrent.*;

public class FutureTaskTest {

    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while(true){
//            从任务池获取一个任务
            Future<String> future = taskCache.get(taskName);
//            如果没获取到就新建个任务
            if (future == null){
                Callable<String> task = () -> taskName;
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName,futureTask);
//                putIfAbsent如果key值存在则返回旧value，如果不存在put进去了就返回null
                if (future == null){
//                    如果放进了任务池中，就将新建的任务给到上面的，然后执行
                    future = futureTask;
                    futureTask.run();
                }
            }

            try {
                return future.get();
            }catch (CancellationException e){
                taskCache.remove(taskName,future);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors() * 2);
    }
}
