package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class BasicTest {

  @Test
  public void test() throws IOException {
    Path p = Paths.get("src/test/resources/basic.txt");
    String output = Files.readString(p);

    System.out.println(output);
    Assert.assertEquals("Hello World!", output);
  }
}
