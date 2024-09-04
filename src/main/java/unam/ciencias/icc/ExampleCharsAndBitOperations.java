package unam.ciencias.icc;

public class ExampleCharsAndBitOperations {

  public static void main(String[] args) {
    System.out.println("** Examples of chars **\n");

    // ascii code [0,255]
    // a - 97, b - 98, ...
    // A - 65, B - 66, ...
    char myChar = 'A';
    // `char` is just a subtype of `int`
    int myCharAsNumber = myChar;

    // print the ascii code of a character
    System.out.println("myChar: " + myChar);
    System.out.println("myCharAsNumber (ascii code): " + myCharAsNumber);

    // print a number in base 10 and then in base 16
    System.out.printf("%d in base 16 is %x\n", myCharAsNumber, myCharAsNumber);


    System.out.println("\n** Examples of string of chars **\n");

    // looking at the each character of a string
    String myString = "abcde";
    System.out.println("String is: " + myString);
    for (char charInString : myString.toCharArray()) {
      System.out.println("char: " + charInString +
                         ", ascii code: " + (int)charInString);
    }


    System.out.println("\n** Examples of numbers **\n");
    // demo of one's complement and two's complement
    int num = 0;
    int onesComplementOfNum = ~num;
    int twosComplementOfNum = onesComplementOfNum + 1;
    System.out.println("num -> " + num + ",\n" +
                       "one's complement (~) -> " + onesComplementOfNum + ",\n" +
                       "two's complement (~ + 1) -> " + twosComplementOfNum);
  }
}
