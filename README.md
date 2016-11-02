#�߳��Լ��̳߳ص�ѧϰ
    ��jdk1.5֮�󣬼�����java.util.concurrent�����������Ҫ������java���̺߳��̳߳ص�ʹ�á�
##�̳߳ص������ǣ�
        ����ϵͳ��ִ���̵߳�������
##ΪʲôҪʹ���̳߳أ�
        1.���ٴ����������̵߳Ĵ�����ÿ�������̶߳����Ա��ظ����ã���ִ�ж������
        
        2.���Ը���ϵͳ�ĳ�������������ϵͳ�й����̵߳�������
##java�ṩ��һЩ�����
        1.java�����̳߳صĶ������ӿ��� **Executor** ,�ϸ����彲�� **Executor** ������һ���̳߳أ���ֻ��ִ���̵߳�һ�����ߡ��������̳߳ؽӿ��� **ExecutorService** ��
        
        2. **ExecutorService** �������̳߳ؽӿڡ��̳��� **Executor** ��
        
        3. **ScheduledExecutorService** ��һ���ӿڣ��̳���  **ExecutorService**,�ܺ�Timer/TimerTask���ƣ������Щ��Ҫ�����ظ�ִ�е����⡣
        
        4. **AbstractExecutorService** ��ʵ���� **ExecutorService** �ĳ����ࡣ
        
        5. **ThreadPoolExecutor** ���̳���**AbstractExecutorService** ��ʵ���ࡣ
        
        6. **ScheduledThreadPoolExecutor** ���̳��� **ThreadPoolExecutor** �� ͬʱʵ���� **ScheduledExecutorService** ��������������ȵ�ʵ�֡�
        
        7.�����ڵ��м��ϸ��ӿ� **Collection** �и������� **Collections**, **Executor** Ҳ��һ�� **Executors**�࣬ **Executors** �������ṩ��һЩ��̬��������������һЩ���õ��̳߳ء�
##Executors�ṩ���̳߳�
    1.newSingleThreadExecutor
    
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }


        ����һ�����̵߳��̳߳ء�
        
        
    2.newFixedThreadPool
    
     public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
    
        ����һ���̶���С���̳߳ء�
        
        
    3.newCachedThreadPool
    
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
    
        ����һ���ɻ�����̳߳ء�
        
    4.newScheduledThreadPool
    
     public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
    
        ����һ����С���޵��̳߳ء�
        
    5.newWorkStealingPool��1.8��
    
     public static ExecutorService newWorkStealingPool() {
        return new ForkJoinPool
            (Runtime.getRuntime().availableProcessors(),
             ForkJoinPool.defaultForkJoinWorkerThreadFactory,
             null, true);
    }
    
        ����һ����С���޵��̳߳ء�
    
        