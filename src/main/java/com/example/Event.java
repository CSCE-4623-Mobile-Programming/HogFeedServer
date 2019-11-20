package com.example;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event
{

  @Id
  //@TableGenerator(name = "EVENT", table = )
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column (name = "title")
  @NotEmpty
  private String title;

  @Column (name = "latitude")
  private String latitude;

  @Column (name = "longitude")
  private String longitude;

  @Column (name = "location")
  private String location;

  @Column (name = "quantity")
  private int quantity;


  // Getters
  public Long getId()  { return id; }

  public String getTitle() { return title; }

  public String getLatitude() { return latitude; }

  public String getLongitude() { return longitude; }

  public String getLocation() { return location; }

  public int getQuantity() { return quantity; }

}
