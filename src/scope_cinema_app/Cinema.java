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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cinema {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private HashMap<User, LinkedList<Show>> shows = new HashMap<User, LinkedList<Show>>();
  private List<User> registeredUsers = new LinkedList<User>();

  private Show bookShow() {
    Show show = null;
    while (true) {
      try {
        System.out.print("\n\nEnter show name: ");
        String showTitle = reader.readLine();
        System.out.print("Enter time slot: ");
        String timeSlot = reader.readLine();

        var time = TimeSlots.valueOf(timeSlot.toUpperCase());

        show = new Show(showTitle, time, 0, null);
        break;
      } catch (IllegalArgumentException e) {
        System.err.print(
            "Invalid Time! Please enter on of the below\nFIRST (10:00)\nSECOND (14:30)\nTHIRD (18_00)\nFOURTH(22_00)\n");
      } catch (IOException e) {
        System.err.print(e.getMessage());
      }
    }
    return show;
  }

  private User getUser() {
    User user = null;

    try {
      System.out.print("Enter username: ");
      var username = reader.readLine();
      System.out.print("Enter age: ");
      var age = Integer.parseInt(reader.readLine());

      if (registeredUsers.stream().anyMatch(u -> (u.getAge() == age && u.getName().compareTo(username) == 0)) == true)
        return registeredUsers.stream().filter(u -> (u.getAge() == age && u.getName().compareTo(username) == 0))
            .findFirst().get();

      System.out.print(
          "Would you like to get a 6 month subscription (Additional Rs3000 will be deducted from your account): (y/n)  ");
      var subscribe = reader.readLine().toLowerCase().charAt(0) == 'y' ? true : false;

      if (subscribe == true) {
        user = new User(username, age, subscribe);
        registeredUsers.add(user);
      } else
        user = new User(username, age, false);

    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return user;
  }

  public void start() {
    while (true) {
      try {
        System.out
            .print("\n\nWelcome to Scope Cinema\n\nEnter\n1. Book Show\n2. List all booked shows\n3. Exit\n\nChoice: ");
        int choice = Integer.parseInt(reader.readLine());

        switch (choice) {
          case 1:
            var user = getUser();

            if (user.getRegistered() == true)
              System.out.println("\nThanks for registering. Welcome " + user.getName() + "!");  //to get the users name

            var show = bookShow();

            if (shows.keySet().contains(user) == false)
              shows.put(user, new LinkedList<Show>());

            shows.get(user).add(show);
            user.setPoints(user.getPoints() + 1);

            if (user.getAge() >= 13) { 
              show.setTicketPrice(600);
              show.setTicketType(TicketType.ADULT_TICKET);
            } else if (user.getAge() < 13) { //<= 12
              show.setTicketPrice(400);
              show.setTicketType(TicketType.HALF_TICKET);
            }

            if (user.getPoints() == 2)
              System.out.println("You've been awarded bronze star for booking 2 movies in a single day. Claim your free drink");
            if (user.getPoints() == 4)
              System.out.println("You've been awarded silver star for booking 3 movies in a single day. Claim your free popcorn");
            if (user.getPoints() == 5)
              System.out.println("You've been awarded gold star for booking 4 movies in a single day. Claim your free pizza");

            break;
          case 2:
            shows.forEach((key, value) -> {
              System.out.println("___________________________________________________");
              System.out.println(key);
              System.out.println(value);
              System.out.println("___________________________________________________");
            });
            break;
          case 3:
            System.exit(0);
          default:
            System.err.print("Invalid choice. Try again...");
            break;
        }

      } catch (IOException | NumberFormatException e) {
        System.err.print("Invalid Input!\n" + e.getMessage());
      }

    }
  }
}
