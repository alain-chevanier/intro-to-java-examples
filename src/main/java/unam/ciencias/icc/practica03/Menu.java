import java.util.Scanner;

public class Menu {
  static final int RECTANGLE = 1;
  static final int OVAL = 2;
  static final int ARROW = 3;
  static final int DIAMOND = 4;

  public static void main(String[] args) {
    Integer userChoice = 0;

    try (Scanner scanner = new Scanner(System.in)) {
      while(true) {
        System.out.println("Seleccione una figura:");
        System.out.println("1. Rentangulo");
        System.out.println("2. Ovalo");
        System.out.println("3. Flecha");
        System.out.println("4. Rombo");

        userChoice = scanner.nextInt();
        System.out.println("\t->: Opcion:" + userChoice);

        if (userChoice < RECTANGLE || userChoice > DIAMOND) {
          System.out.println("Opcion no valida");
          return;
        }

        if (userChoice == RECTANGLE) {
          Rectangle.print(scanner);
        }
      }
    }
  }
}
