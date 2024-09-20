package unam.ciencias.icc;

public class StringsAndArrays {
  public static void main(String[] args) {
    String hello = "Hello ";
    String world = "World!";
    String helloWorld = hello + world;
    System.out.println(helloWorld);

    char[] charArray = new char[5];
    // charArray (address, length)
    // [ 0, 0, 0, 0, 0] (indexed de 0, (4) length - 1)
    charArray[4] = '&';
    // [0, 0, 0, 0, '&']
    System.out.println("charArray[4] -> " + charArray[4]);

    char[] otherCharArray = new char[6];
    // [ 0, 0, 0, 0, 0, 0]
    otherCharArray[4] = charArray[4];
    // [ 0, 0, 0, 0, '&', 0]

    char[] strCharArray = helloWorld.toCharArray();

    strCharArray[6] = 'X';
    System.out.println("strCharArray[6] -> " + strCharArray[6]);
    System.out.println("helloWorld[6] -> " + helloWorld.charAt(6));

    String a = "HolaX";//"Hola Mundo!";
    String b = "oHal";//"odHo! lanuM";

    System.out.printf("areAnagrams(%s, %s) -> %b\n", a, b, areAnagrams(a, b));

    String str =  "abccba";
    System.out.printf("isPalindrome(%s) -> %b\n", str, isPalindrome(str));
  }


  static boolean isPalindrome(String str) {
    int beg = 0;
    int end = str.length() - 1;
    while (beg < end) {
      char charBeg = str.charAt(beg);
      char charEnd = str.charAt(end);
      if (charBeg != charEnd) {
        return false;
      }
      beg++; // beg = beg + 1;
      end--; // end = end - 1;
    }
    return true;
  }

  static boolean areAnagrams(String a, String b) {
    // a & b son anagramas si contienen los mismos caracteres
    // el mismo numero de veces
    if (a.length() != b.length()) {
      return false;
    }
    //
    for (char charInB : b.toCharArray()) {
      int ocurrenciesInB = occurrencies(b, charInB);
      int ocurrenciesInA = occurrencies(a, charInB);
      if (ocurrenciesInA != ocurrenciesInB) {
        return false;
      }
    }

    return true;
  }

  static int occurrencies(String str, char a) {
    int count = 0;

    // for (int i = 0; i < str.length(); i++) {
    //   char current = str.charAt(i);
    // }

    for (char current : str.toCharArray()) {
      if (current ==  a) {
        count++;
      }
    }
    return count;
  }
}
