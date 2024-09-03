package org.example;

import java.util.ArrayList;
import java.util.List;

public class FibonacciGivenTwoNums {

  public static void main(String[] args) {
    System.out.println(fibonacciGivenTwoNums(34,610));
  }

  public static List<Integer> fibonacciGivenTwoNums(int start, int end) {
    int first = 0;
    int second = 1;
    List<Integer> result = new ArrayList<>();

    if (start > end) {
      return result;
    }

    if (first >= start && first <= end) {
      result.add(first);
    }
    if (second >= start && second <= end) {
      result.add(second);
    }

    int current;
    do {
      current = first + second;
      if (current >= start && current <= end) {
        result.add(current);
      }
      first = second;
      second = current;
    } while(current < end);
    return result;
  }

}
