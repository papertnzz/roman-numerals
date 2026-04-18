import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int num = Integer.parseInt(scanner.nextLine().trim());
      System.out.println(toRoman(num));
    } catch (NumberFormatException e) {
      System.out.println("Input error: not a valid integer");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public static String toRoman(int num) {
    if (num < 1 || num > 3000) {
      throw new IllegalArgumentException("Number must be between 1 and 3000");
    }
    int[] values = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    };
    String[] numerals = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        num -= values[i];
        result.append(numerals[i]);
      }
    }
    return result.toString();
  }

}