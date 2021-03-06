package com.test;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestJunit {
    //测试方法必须有@test；
    //该测试方法必须由public void修饰，没有返回值；
    //该方法不带任何参数；
    //新建一个源代码测试文件单独存放测试代码；
    //测试类的包和被测试类的包保持一致；
    //测试方法间互相独立没有任何依赖；
    @Test
    public void testAdd(){

        assertEquals(3, new MethodJunit().add(3, 0));
    }

    @Test
    public void testSubtract(){
        assertEquals(3, new MethodJunit().subtract(6, 3));
    }

    @Test
    public void testMultiply(){
        assertEquals(6, new MethodJunit().multiply(6, 1));
    }

    @Test
    public void testDivision(){ assertEquals(6, new MethodJunit().division(6, 1));}
}

class MethodJunit {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        return a / b;
    }
}
