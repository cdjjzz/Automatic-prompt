package com.xp.prompt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskPool {

    private static TaskPool task = new TaskPool(20);
    ;

    public static TaskPool getInstance() {
        return task;
    }

    private ThreadPoolExecutor pool;

    private List<String> dic;

    public TaskPool(int poolSize) {
        pool = new ThreadPoolExecutor(poolSize, poolSize, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        pool.prestartAllCoreThreads();
    }

    public void setDic(List<String> dic) {
        this.dic = dic;
    }

    public String matchString(String input) throws ExecutionException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        List<Future<String>> result = new ArrayList<Future<String>>(dic.size());
        for (String dicString : dic) {
            result.add(pool.submit(new CharMatching(input, dicString)));
        }

        for (Future<String> future : result) {
            String data = future.get();
            if (data != null) {
                sb.append(data);
                sb.append(" ");
            }
        }


        return sb.toString();
    }
}
