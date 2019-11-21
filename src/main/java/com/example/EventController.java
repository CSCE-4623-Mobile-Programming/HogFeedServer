package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController
{
  private EventRepository repository;

  @Autowired
  public EventController(EventRepository repository)
  {
    this.repository = repository;
  }

  // This GET method returns the JSON of an event using it's ID
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Event> get(@PathVariable("id") Long id)
  {
    Event event = repository.findOne(id);
    if (null == event)
    {
      return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Event>(event, HttpStatus.OK);
  }

  // This POST method inserts or updates values into the database
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ResponseEntity<Event> update(@RequestBody Event event)
  {
    repository.save(event);
    return get(event.getId());
  }

  // This GET method returns all the entries on dB
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<Event> all()
  {
      return repository.findAll();
  }


  @RequestMapping(value = "/picture/{p_name}", method = RequestMethod.GET)
  public ResponseEntity<byte[]> getPicture( @PathVariable String p_name ) throws IOException
  {
    PrintStream out=System.out;

    // Get file path
    String filePathString = "/com/example/pictures/" + p_name + ".jpg";


    ClassPathResource imageFile = new ClassPathResource(filePathString);

    try
    {
      byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());

      return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    catch (Exception e)
    {
      out.println("Errored");
      return null;
    }




    //Image picture = new Image(filePathString.trim());

    /*
    if ( picture.exists())
    {
      return "Yup";
    }
    else
    {
      return "Nah";
    }

     */
  }
}
