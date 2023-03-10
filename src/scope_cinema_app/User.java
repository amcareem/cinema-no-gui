/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scope_cinema_app;

/**
 * This program was created by Ahamed Careem (Github: amcareem, LinkedIn: https://www.linkedin.com/in/ahamedmusthafacareem/)
 *
 * All rights reserved. Copying or publishing this code anywhere else without permission is strictly prohibited.
 */
import java.util.Objects;

public class User {
  private String name;
  private int age;
  private boolean registered = false;
  private int points = 0;

  public User(String name, int age, boolean registered) {
    this.name = name;
    this.age = age;
    this.registered = registered;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public boolean getRegistered() {
    return registered;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }

  @Override
  public String toString() {
    return String.format("Name: %s\nAge: %d\nRegistered: %b\nPoints: %d", name, age, registered, points);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    // null check
    if (o == null)
      return false;
    // type check and cast
    if (getClass() != o.getClass())
      return false;
    var user = (User) o;
    // field comparison

    return Objects.equals(this.name, user.name)
        && Objects.equals(this.age, user.age)
        && Objects.equals(this.registered, user.registered);
  }
}
