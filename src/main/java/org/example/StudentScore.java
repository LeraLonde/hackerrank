package org.example;

import java.util.Arrays;

public class StudentScore {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(studentScores(new int[] {1,2,2,3})));
  }

  public static int[] studentScores(int[] studentScores) {
    if (studentScores.length <= 2) {
      return studentScores;
    }

    int[] result = new int[studentScores.length];
    Arrays.sort(studentScores);

    int middleIdx = studentScores.length / 2;
    result[0] = studentScores[middleIdx];
    studentScores[middleIdx] = -1;

    int frontPointer = 0;
    int backPointer = studentScores.length - 1;

    for (int i = 1; i < result.length; i++) {
      if (i % 2 == 0) {
        result[i] = studentScores[frontPointer];
        frontPointer++;
      } else {
        result[i] = studentScores[backPointer];
        backPointer--;
      }

      if (frontPointer == middleIdx) {
        frontPointer++;
      }

      if (backPointer == middleIdx) {
        backPointer--;
      }

      if (frontPointer > backPointer) {
        break;
      }
    }

    return result;
  }
}
