package com.example.demo.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author daizhichao
 * @date 2019/3/26
 */
public class SyncTest {

    private static final int thread_size = 10;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(thread_size);

    public class UserActionCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            new FileStorage().writeUserActions();
            return 1;
        }
    }

    private void test() {
        int processNum = 0;
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new UserActionCallable()));
        }
        if (futures.size() == thread_size) {
            for (Future<Integer> future : futures) {
                try {
                    processNum += future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            futures.clear();
        }
        System.out.println(processNum);
        executorService.shutdown();
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        syncTest.test();
    }
}
