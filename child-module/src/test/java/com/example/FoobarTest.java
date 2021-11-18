package com.example;

import org.junit.Test;
import org.mockito.Mockito;

public class FoobarTest {

  @Test
  public void testWithMock() {
    SimpleClass simple = Mockito.mock(SimpleClass.class);
    simple.helloWorld();
  }

  @Test
  public void test1() {
    System.out.println("test");
  }

  @Test
  public void test2() {
    System.out.println("test");
  }

  @Test
  public void test3() {
    System.out.println("test");
  }
}
