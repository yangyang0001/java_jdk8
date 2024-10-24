package com.deepblue.mine_02_deepsource.example_006_stream_map;

/**
 * 本例子证明了 lambda表达式 和 内部类的实现从根本上就是不一样的,作用域不同!
 */
public class MineScope {

    Runnable r1 = () -> System.out.println("first ------:" + this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("second -----:" + this);
        }
    };

    public static void main(String[] args){

        MineScope test = new MineScope();

        Thread thread1 = new Thread(test.r1);
        thread1.start();

        System.out.println("---------------------------------------------------");

        Thread thread2 = new Thread(test.r2);
        thread2.start();

    }
}
