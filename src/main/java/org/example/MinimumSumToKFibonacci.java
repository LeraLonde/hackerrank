package org.example;

import java.util.ArrayList;
import java.util.List;

public class MinimumSumToKFibonacci {

  public static void main(String[] args) {
    System.out.println(minSumToKFibonacci(7));
    System.out.println(minSumToKFibonacci(10));
    System.out.println(minSumToKFibonacci(19));
  }

  public static int minSumToKFibonacci(int k) {
    List<Integer> sequence = new ArrayList<>();
    sequence.add(0);
    sequence.add(1);

    int first = sequence.get(0);
    int second = sequence.get(1);

    int current;
    do {
      current = first + second;
      sequence.add(current);
      first = second;
      second = current;
    } while(current < k);

    int count = 0;
    for (int i = sequence.size()-1; i >= 0; i--) {
      if (sequence.get(i) <= k) {
        k -= sequence.get(i);
        count++;
      }

      if (k == 0) {
        return count;
      }
    }
    return -1;
  }
}
