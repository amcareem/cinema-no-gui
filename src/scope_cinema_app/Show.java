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
public class Show {
  private String title;
  private TimeSlots timeSlot;
  private int ticketPrice;
  private TicketType ticketType;

  public Show(String title, TimeSlots timeSlot, int ticketPrice, TicketType ticketType) {
    this.title = title;
    this.timeSlot = timeSlot;
    this.ticketPrice = ticketPrice;
    this.ticketType = ticketType;
  }

  public String getTitle() {
    return title;
  }

  public TimeSlots getTimeSlot() {
    return timeSlot;
  }

  public int getTicketPrice() {
    return ticketPrice;
  }

  public TicketType getTicketType() {
    return ticketType;
  }

  public void setTicketPrice(int ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public void setTicketType(TicketType ticketType) {
    this.ticketType = ticketType;
  }

  @Override
  public String toString() {
    return String.format(
        "\n\n----------------------\nSHOW\n\nTitle: %s\nTime: %s\nTicket Price: %d----------------------\n\n",
        this.title,
        this.timeSlot, this.ticketPrice);
  }

}

