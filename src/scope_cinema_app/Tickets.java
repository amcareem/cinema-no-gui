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
public enum Tickets {
  FULL(600), HALF(400);
  
  Tickets(int value) {
    this.value = value;
  }

  private int value;

  public String toString() {
      return Integer.toString(value);
  }
}