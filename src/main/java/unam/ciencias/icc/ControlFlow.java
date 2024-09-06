package unam.ciencias.icc;

public class ControlFlow {
  public static void main(String[] args) {
    int num = 1324123498;
    System.out.printf("%d isOdd -> %b\n", num, isOdd(num));

    // Corrimiento de bits hacia la izquierda
    // es equivalente a multiplicar por una potencia de dos
    // i.e. `num << n` es equivalente a `num * 2^n`
    int num2 = 1;
    int exp = 2;
    // Ejemplo: 1 << 2. Si utilizamos 5 bits para representar el numero.
    // 00001 << 2 = 00100 [recorre el 1, 2 posiciones hacia la izquierda]
    System.out.printf("%d << %d -> %d\n", num2, exp, num2 << exp);

    System.out.printf("2^%d -> %d\n", 5, pow2(5));

    // Corrimiento de bits hacia la derecha
    // es equivalente a dividir por una potencia de dos
    // i.e. `num >> n` es equivalente a `num / 2^n`
    int num3 = 3;
    int exp3 = 1;
    // Ejemplo : 3 >> 1. Si utilizamos 5 bits para representar el numeor
    // 00011 >> 1 -> 00001 [recorre todos los bits una posicion a la derecha]
    System.out.printf("%d >> %d -> %d\n", num3, exp3, num3 >> exp3);

    // Utilizando todo lo anterior
    int num4 = 28; // 011100 -> 3 bits prendidos
    System.out.printf("countOnes(%d) -> %d\n", num4, countOnes(num4));
  }

  /*
   * Un numero es impar si su ultimo bit esta prendido
   */
  static boolean isOdd(int num) {
    return (num & 1) == 1;
  }

  /**
   * calcula 2 ^ num [num >= 0]
   */
  static int pow2(int num) {
    return 1 << num;
  }

  /**
   * Cuenta el numero de bits prendidos de `num`
   */
  static int countOnes(int num) {
    int count = 0;
    while (num > 0) {
      int lastBitValue = num & 1;
      if (lastBitValue == 1) {
        count = count + 1;
      }
      num = num >> 1;
    }
    return count;
  }

}
