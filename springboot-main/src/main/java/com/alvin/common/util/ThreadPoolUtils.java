package com.alvin.common.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池工具类
 *
 * @author tianyunperfect
 * @date 2021/02/03
 */
public class ThreadPoolUtils {

    /**
     * 获取线程池
     *
     * @param corePoolSize    核心池大小
     * @param maximumPoolSize 最大池大小
     * @param keepAliveTime   维持时间
     * @param unit            单位
     * @param queueSize       队列的大小
     * @param poolName        池名称
     * @param handler         拒绝策略
     * @return {@link ThreadPoolExecutor}
     */
    public static ThreadPoolExecutor getThreadPool(
            int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
            int queueSize,
            String poolName,
            RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize,
                keepAliveTime, unit,
                new LinkedBlockingDeque<>(queueSize),
                new MyThreadFactory(poolName),
                handler
        );
    }


    /**
     * 修改于默认线程池工程类，添加了自定义线程名
     *
     * @author tianyunperfect
     * @date 2021/02/03
     */
    public static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            //自定义名称
            if (name == null || name.isEmpty()) {
                name = "pool";
            }
            namePrefix = name + "-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
