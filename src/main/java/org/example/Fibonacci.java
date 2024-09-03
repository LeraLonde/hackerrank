package org.example;

import java.util.Arrays;

public class Fibonacci {

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++)
      System.out.println(fibonacci(i));
  }

  public static int fibonacci(int n) {
    int first = 0;
    int second = 1;

    if (n == 0) {
      return first;
    }
    if (n == 1) {
      return second;
    }

    int result = 0;
    for (int i = 2; i <= n; i++) {
      result = first + second;
      first = second;
      second = result;
    }

    return result;
  }
}
