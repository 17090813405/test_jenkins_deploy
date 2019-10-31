package com.example.demo.future;

import java.util.concurrent.*;

/**
 * @author daizhichao
 * @date 2019/3/1
 */
public class FutureTest {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        ExecutorService executor =
                new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<String> future = executor.submit(() -> {
            System.out.println("running task");
            Thread.sleep(10000);
            return "return task";
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        //前面的的 Callable 在其他线程中运行着，可以做一些其他的事情
        System.out.println("do something else");

        try {
            //等待 future 的执行结果，执行完毕之后打印出来
            System.out.println(future.get(10L,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {

        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
