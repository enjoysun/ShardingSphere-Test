package com.myou.shardingsphere;

/**
 * @Author myou
 * @Date 2021/8/3  6:06 下午
 */
public class test {
    public static void main(String[] args) {
        String s = new String("1");
        String s1 = new String("1") + new String("1");
        System.out.println(-1 << 29);
        baby:
        for (int i = 0; i < 10; i++) {
            System.out.println("外部:" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("内部:" + j);
                if (j == 3) {
                    break baby;
                }
            }
        }
        System.out.println("ok");
    }
}
