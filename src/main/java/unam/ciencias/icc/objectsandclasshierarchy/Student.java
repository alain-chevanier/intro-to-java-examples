package unam.ciencias.icc.objectsandclasshierarchy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
  private int age;
  private String name;
  private String lastName;
  private String accountNumber;
  private String major;

  public String getFullName() {
    return this.name + " " + this.lastName;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMajor() {
    return this.major;
  }

  /*
  public void setAge(int age) {
    this.age = age;
  }

  public void setName(String name) {
    this.name = new StringBuffer(name);
  }

  public void setLastName(String lastName) {
    this.lastName = new StringBuffer(lastName);
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public int getAge() {
    return age;
  }

  public StringBuffer getName() {
    return name;
  }

  public StringBuffer getLastName() {
    return lastName;
  }

  public String getAccountNumber() {
    return accountNumber;
  }*/

}
