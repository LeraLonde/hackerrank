package org.example;

import java.util.HashMap;

public class Hexspeak {

  public static void main(String[] args) {
    System.out.println(hexSpeakConversion("257"));
  }

  public static String hexSpeakConversion(String input) {
    HashMap<Integer, String> mapping = new HashMap<>();
    mapping.put(0, "O");
    mapping.put(1, "I");
    mapping.put(10, "A");
    mapping.put(11, "B");
    mapping.put(12, "C");
    mapping.put(13, "D");
    mapping.put(14, "E");
    mapping.put(15, "F");

    try {
      int intInput = Integer.parseInt(input);
      String result = "";

      int tempInput = intInput;
      while (tempInput > 0) {
        int remainder = tempInput % 16;
        tempInput = tempInput / 16;
        System.out.println(tempInput);

        if (!mapping.containsKey(remainder)) {
          return "ERROR";
        }
        result += mapping.get(remainder);
      }
      return result;
    } catch (NumberFormatException ex) {
      return "ERROR";
    }
  }
}
