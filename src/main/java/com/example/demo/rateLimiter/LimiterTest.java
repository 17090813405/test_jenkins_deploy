package com.example.demo.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;

/**
 * 高效限速器RateLimiter测试使用
 *
 * @author daizhichao
 * @date 2019/10/22
 */
public class LimiterTest {

    public static void main(String[] args) throws InterruptedException {
        final RateLimiter rateLimiter = RateLimiter.create(10);
        int maxNum = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(maxNum);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < maxNum; i++) {
            Thread thread = new Thread(() -> {
                rateLimiter.acquire();
                System.out.println("run_Task:" + Thread.currentThread().getName());
                countDownLatch.countDown();
            });
            thread.setName("thread_" + i);
            thread.start();
        }
        countDownLatch.await();
        System.out.println("end taskTime:" + (System.currentTimeMillis() - startTime));
    }
}
