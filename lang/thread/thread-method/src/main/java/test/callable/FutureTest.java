package test.callable;

import thread.CallableInstance;

import java.util.concurrent.*;

/**
 * Future 一共有五个方法
 * isDone()：            判断任务是否完成。
 * isCancelled()：       判断任务是否取消。
 * get()：               获取计算结果（一致等待，直至得到结果）。
 * cancel(true)：        取消任务。
 * get(long,TimeUnit)：  规定时间内获取计算结果（在long时间内等待结果，如果得到则返回；如果未得到，则结束，并抛出TimeoutException异常）。
 */
public class FutureTest {

    public static void main(String[] args) {

        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 向线程池提交任务 one
        Future<Integer> one = executorService.submit(new CallableInstance());

        try {
            long begin = System.currentTimeMillis();
            System.out.println("future one 开始执行任务");
            System.out.println("通过future.isDone()      判断任务是否计算完成：" + one.isDone());
            System.out.println("通过future.isCancelled() 判断任务是否取消：" + one.isCancelled());
            System.out.println("通过future.get()         获取任务的计算结果(从任务开始就一直等待，直至有返回值)：" + one.get());
            System.out.println("future one 结束执行任务  共计用时：" + (System.currentTimeMillis() - begin) + "ms.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("通过future.isDone()      判断任务是否计算完成：" + one.isDone());
            System.out.println("通过future.isCancelled() 判断任务是否取消：" + one.isCancelled());
        }

        // 向线程池提交任务 two
        Future<Integer> two = executorService.submit(new CallableInstance());
        try {
            System.out.println("\nfuture two 开始执行任务");
            System.out.println("通过future.get(long,TimeUnit)获取任务的计算结果(1秒钟之后再获取结果)："
                    + two.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("在一秒内没有等到查询结果，不再等待..");
            System.out.println("通过future.isDone()      判断任务是否计算完成：" + two.isDone());
            System.out.println("通过future.isCancelled() 判断任务是否取消：" + two.isCancelled());
            System.out.println("通过future.cancel()      取消这个任务：");
            two.cancel(true);
            System.out.println("通过future.isDone()      判断任务是否计算完成：" + two.isDone());
            System.out.println("通过future.isCancelled() 判断任务是否取消：" + two.isCancelled());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
