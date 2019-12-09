package com.example;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @TableGenerator(name = "events")
  private long id;

  @Column (name = "title", length = 65536)
  @NotEmpty
  private String title;

  @Column (name = "latitude", length = 65536)
  private String latitude;

  @Column (name = "longitude", length = 65536)
  private String longitude;

  @Column (name = "location", length = 65536)
  private String location;

  @Column (name = "quantity", length = 65536)
  private int quantity;

  @Column(name = "pictureid", length = 65536)
  @NotEmpty
  private String pictureID;

  @Column(name = "description", length = 65536)
  private String description;


  // Getters
  public Long getId()  { return id; }

  public String getTitle() { return title; }

  public String getLatitude() { return latitude; }

  public String getLongitude() { return longitude; }

  public String getLocation() { return location; }

  public int getQuantity() { return quantity; }

  public String getpictureID() { return pictureID;}

  public String getDescription() { return description; }

}
