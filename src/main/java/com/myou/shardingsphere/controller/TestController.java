package com.myou.shardingsphere.controller;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author myou
 * @Date 2021/8/30  6:46 下午
 */
public class TestController {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(1);
//        boolean b = atomicInteger.compareAndSet(2, 3);
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "1");
//        map.put("3", "1");
//        map.put("4", "1");
//        map.put("5", "1");
//        map.put("6", "1");
//        map.put("7", "1");
//        map.put("8", "1");
//        map.put("9", "1");
//        map.put("10", "1");
//        map.put("11", "1");
//        map.put("12", "1");
//        map.put("13", "1");
//        map.put("14", "1");
//        map.put("15", "1");
//        map.put("16", "1");
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        int[] newArr = new int[9];
//        // 数组扩容 将老数组扩容至新数组
//        System.arraycopy(arr, 0, newArr, 0, arr.length);
//        // 数组指定位增加新元素(newarr 5，6之间新增元素8) size=6
//        System.arraycopy(newArr, 5, newArr, 5 + 1, 1);
//        Split strings = new Split("123|456|789");
//        for (String str : strings) {
//            System.out.println(str);
//        }
//        Integer add = TestController.add(1, 2);
//        Number number = TestController.add(2, 2.2);
//        Serializable serializable = TestController.add(2, "2");
//        System.out.println("ok");
        SelfBeanFactory selfBeanFactory = new SelfBeanFactory();
        if (selfBeanFactory instanceof ObjectNameAware){
            selfBeanFactory.setName("123");
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        Ticket ticket = new Ticket(reentrantLock);
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        thread1.start();
        thread2.start();
        System.out.println("ok");
    }

    public static <T> T add(T a, T b) {
        return b;
    }
    /*
     * static final int spread(int h) {
     *    return (h ^ (h >>> 16)) & HASH_BITS;
     *}
     * HASH_BITS=0x7fffffff ，二进制为 0111 1111 1111 1111 1111 1111 1111 1111 。
     * spread函数保证(h ^ (h >>> 16))操作后最高位为0
     * */
}

class Split implements Iterable<String> {

    private String[] results;

    public Split(String source) {
        results = source.split("\\|");
    }

    @Override
    public Iterator<String> iterator() {

        class iter implements Iterator<String> {

            private int cur = 0;

            @Override
            public boolean hasNext() {
                return cur != results.length;
            }

            @Override
            public String next() {
                String result = results[cur];
                cur++;
                return result;
            }

            @Override
            public void remove() {

            }
        }
        return new iter();
    }
}

class Ticket implements Runnable {

    private final ReentrantLock lock;

    public Ticket(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(String.format("%s-取票中", Thread.currentThread().getId()));
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    class A extends AbstractQueuedSynchronizer {

    }
}

interface ObjectNameAware {
    void setName(String name);
}

class SelfBeanFactory implements ObjectNameAware {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }
}