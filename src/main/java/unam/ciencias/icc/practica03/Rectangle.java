import java.util.Scanner;

public class Rectangle {
  static final String SELECT_HEIGHT = "Seleccione la altura (h): ";
  static final String SELECT_BASE = "Seleccione la base (b)";

  static void print(Scanner scanner) {
    int height, base;
    System.out.println(SELECT_HEIGHT);
    height = scanner.nextInt();
    System.out.println(SELECT_BASE);
    base = scanner.nextInt();

    renderRectangle(height, base);
  }

  static void renderRectangle(int height, int base) {
    String rowStr = "";
    for (int column = 0; column < base; column++) {
      rowStr += "*";
    }
    System.out.println("");
    for (int row = 0; row < height; row++) {
      System.out.println(rowStr);
    }
    System.out.println("");
  }
}
