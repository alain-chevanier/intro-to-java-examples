package unam.ciencias.icc;

public class StringsAndArrays {
  public static void main(String[] args) {
    String hello = "Hello ";
    String world = "World!";
    String helloWorld = hello + world;
    System.out.println(helloWorld);

    char[] charArray = new char[5];
    // charArray (address, length)
    // [ 0, 0, 0, 0, 0] (indexed from 0 to (4) length - 1)
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

    String a = "Hola Mundo!";
    String b = "odHo! lanuM";

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
    if (a.length() != b.length()) {
      return false;
    }
    // a & b are considered anagrams if both contain the same
    // ocurrencies of the same characters
    for (char charInB : b.toCharArray()) {
      int ocurrenciesInB = countOccurrenciesOf(charInB, b);
      int ocurrenciesInA = countOccurrenciesOf(charInB, b);
      if (ocurrenciesInA != ocurrenciesInB) {
        return false;
      }
    }

    return true;
  }

  static int countOccurrenciesOf(char a, String str) {
    int count = 0;

    // for (int i = 0; i < str.length(); i++) {
    //   char current = str.charAt(i);
    //   ...
    // }

    // equivalent to the code above
    for (char current : str.toCharArray()) {
      if (current ==  a) {
        count++;
      }
    }
    return count;
  }
}
