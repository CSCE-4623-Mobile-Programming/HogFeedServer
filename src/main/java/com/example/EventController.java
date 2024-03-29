package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


  // This POST method deletes an event using it's ID
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public String delete(@PathVariable("id") Long id)
  {
      try
      {
        // Check if element is on dB
        Event event = repository.findOne(id);
        if (null == event)
        {
          return "Element Not Found on Database";
        }
        else
        {
          repository.delete(id);
          return (id + " element deleted from Database");
        }
      }
      catch (Exception e)
      {
        return e.toString();
      }
  }
}
