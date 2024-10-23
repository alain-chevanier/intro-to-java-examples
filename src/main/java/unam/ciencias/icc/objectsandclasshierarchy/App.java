package unam.ciencias.icc.objectsandclasshierarchy;

public class App {
  public static void main(String[] args) {
    Student ricchy = new Student();
    ricchy.setName("Ricchy");
    ricchy.setLastName("Chevanier");
    ricchy.major = "Computer Sciences";

    System.out.println("ricchy.fullName: " + ricchy.getFullName());
    System.out.println("ricchy.major: " + ricchy.major);
  }
}
