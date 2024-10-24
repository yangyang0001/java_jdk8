package com.deepblue.mine_02_deepsource.example_005_stream_source;

/**
 * 
 */
public class AutoCloseableTest implements AutoCloseable {

    public static void main(String[] args) {
        //这种方式是try with resource的方式来关闭流的操作!jdk7以后推荐使用!
        try (AutoCloseableTest test = new AutoCloseableTest()) {
            test.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("close invoked !");
    }

    public void doSomething() {
        System.out.println("doSomething invoked!");
    }
}
