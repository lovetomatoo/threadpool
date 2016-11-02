#线程以及线程池的学习
    在jdk1.5之后，加入了java.util.concurrent包，这个包主要介绍了java中线程和线程池的使用。
##线程池的作用是：
        限制系统中执行线程的数量。
##为什么要使用线程池：
        1.减少创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
        
        2.可以根据系统的承受能力，调整系统中工作线程的数量。
##java提供的一些相关类
        1.java里面线程池的顶级跟接口是 **Executor** ,严格意义讲， **Executor** 并不是一个线程池，而只是执行线程的一个工具。真正的线程池接口是 **ExecutorService** 。
        
        2. **ExecutorService** 真正的线程池接口。继承自 **Executor** 。
        
        3. **ScheduledExecutorService** ，一个接口，继承自  **ExecutorService**,能和Timer/TimerTask类似，解决那些需要任务重复执行的问题。
        
        4. **AbstractExecutorService** ，实现了 **ExecutorService** 的抽象类。
        
        5. **ThreadPoolExecutor** ，继承自**AbstractExecutorService** ，实现类。
        
        6. **ScheduledThreadPoolExecutor** ，继承自 **ThreadPoolExecutor** ， 同时实现了 **ScheduledExecutorService** 。周期性任务调度的实现。
        
        7.类似于单列集合跟接口 **Collection** 有个工具类 **Collections**, **Executor** 也有一个 **Executors**类， **Executors** 类里面提供了一些静态工厂，用于生成一些常用的线程池。
##Executors提供的线程池
    1.newSingleThreadExecutor
    
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }


        创建一个单线程的线程池。
        
        
    2.newFixedThreadPool
    
     public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
    
        创建一个固定大小的线程池。
        
        
    3.newCachedThreadPool
    
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
    
        创建一个可缓存的线程池。
        
    4.newScheduledThreadPool
    
     public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
    
        创建一个大小无限的线程池。
        
    5.newWorkStealingPool（1.8）
    
     public static ExecutorService newWorkStealingPool() {
        return new ForkJoinPool
            (Runtime.getRuntime().availableProcessors(),
             ForkJoinPool.defaultForkJoinWorkerThreadFactory,
             null, true);
    }
    
        创建一个大小无限的线程池。
    
        