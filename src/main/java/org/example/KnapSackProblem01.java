package org.example;

import java.util.Arrays;

public class KnapSackProblem01 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(knapSack(new int[]{2,3,4,5}, new int[]{1,2,5,6}, 8)));
  }

  public static int[] knapSack(int[] weights, int[] values, int wt) {
    int[][] map = generateMap(weights, values, wt);
    int[] results = new int[weights.length];

    int currentRow = map.length-1;
    int currentCol = wt;

    // Terminate when i encounter a zero
    while (map[currentRow][currentCol] != 0) {
      // current value
      int currentValue = map[currentRow][currentCol];

      // if not the first row
      if (currentRow != 0) {
        // I have to check above
        int valueAbove = map[currentRow-1][currentCol];
        // if equal, means the value come from above and the current item is not chosen
        if (currentValue == valueAbove) {
          results[currentRow] = 0;
          currentRow--;
        } else {
          results[currentRow] = 1;
          currentCol = currentCol - weights[currentRow];
          currentRow--;
        }
      } else {
        // if I am at first row and the item is not 0 means it was chosen
        if (map[currentRow][currentCol] != 0) {
          results[currentRow] = 1;
          break;
        }
      }
    }
    return results;
  }

  private static int[][] generateMap(int[] weights, int[] values, int wt) {
    int[][] map = new int[weights.length][wt + 1];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        int currentWeight = weights[i];
        int currentValue = values[i];
        // first column when weight = 0
        if (j == 0) {
          map[i][j] = 0;
          continue;
        }

        // when weight is non zero
        if (i == 0) {
          if (currentWeight <= j) {
            map[i][j] = currentValue;
          } else {
            map[i][j] = 0;
          }
        } else {
          if (currentWeight > j) {
            map[i][j] = map[i-1][j];
          } else {
            int valueOfNotInclude = map[i-1][j];
            int valueOfIncludeCurrent = currentValue + map[i-1][j - currentWeight];
            map[i][j] = Math.max(valueOfNotInclude, valueOfIncludeCurrent);
          }
        }
      }
      System.out.println(Arrays.toString(map[i]));
    }
    return map;
  }
}
