package com.example;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotEmpty
  private String title;

  private String latitude;
  private String longitude;
  private String location;
  private int quantity;


  // Getters
  public Long getId() {
    return id;
  }

  public String getTitle() { return title; }

  public String getLatitude() { return latitude; }

  public String getLongitude() { return longitude; }

  public String getLocation() { return location; }

  public int getQuantity() { return quantity; }

}
