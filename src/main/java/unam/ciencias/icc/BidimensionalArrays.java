package unam.ciencias.icc;

public class BidimensionalArrays {
  public static void main(String[] args) {

    // un arreglo por definicion se compone de dos datos
    // 1. la direccion en la memoria en la que comienza
    // 2. su capacidad (fija, .length en java)
    int[] array = new int[4];

    // 5 arreglos de tamano 4
    // es como una matrix de 5 x 4
    int[][] biArray = new int[5][4];

    // en la posicion 3, del arreglo 2, escribimos un 1
    biArray[2][3] = 1;

    // tambien podemos tener arreglos bidimensionales
    // en donde la segunda dimension de arreglos no sean del
    // tamano, por ejemplo a continuacion creamos dos arreglos,
    // el primero de tamano 4, y el segundo de tamano 3
    int[][] otherBiArray = new int[][] {new int[]{0, 1, 2, 3},
                                        new int[]{4, 5, 6}};

    // alternativamente podemos crear el mismo arreglo que arriba
    // de la siguiente manera:
    int[][] nextBiArray = new int[2][];
    nextBiArray[0] = new int[]{0, 1, 2, 3};
    nextBiArray[1] = new int[]{4, 5, 6};

    // Nota: la primera dimesion de un arreglo bidimensional funciona como
    // un arreglo de direcciones
    System.out.println("nextBiArray.length: " + nextBiArray.length);
    System.out.println("nextBiArray[0].length: " + nextBiArray[0].length);
    System.out.println("nextBiArray[1].length: " + nextBiArray[1].length);
  }

  /*
   * Work In Progress, funcion que construye el triangulo de pascal
   * de N niveles.
   */
  public static int[][] buildPascalTriangle(int levels) {
    int[][] triangle = new int[levels][];
    int[] prevLevel = new int[] {};
    for (int level = 0; level < triangle.length; level++) {
      int[] newLevel = new int[level + 1];
      newLevel[0] = 1;
      newLevel[level] = 1;

      for (int i = 0; i < prevLevel.length - 1; i++) {
        newLevel[i+1] = prevLevel[i] + prevLevel[i+1];
      }

      triangle[level] = newLevel;
      prevLevel = newLevel;
    }
    return triangle;
  }
}
