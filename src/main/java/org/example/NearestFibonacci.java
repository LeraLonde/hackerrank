package org.example;

import java.util.Arrays;

public class NearestFibonacci {

  public static void main(String[] args) {
    System.out.println(nearestFibonacci(20));

    System.out.println(nearestFibonacci(17));
  }

  public static int nearestFibonacci(int target) {
    int first = 0;
    int second = 1;
    int current = first + second;

    while (current < target) {
      first = second;
      second = current;
      current = first + second;
    }

    int currentDistToTarget = Math.abs(current - target);
    int secondDistToTarget = Math.abs(second - target);

    return currentDistToTarget < secondDistToTarget ? current : second;
  }
}
