package unam.ciencias.icc;

import unam.ciencias.icc.objectsandclasshierarchy.Student;

public class ObjectInMainPackage {


  public static void main(String[] args) {
    Student irving = new Student();
    irving.setMajor("math");

    System.out.println("irving.major: " + irving.getMajor());
  }


}
