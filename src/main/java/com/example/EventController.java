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
  public EventController(EventRepository repository) {
    this.repository = repository;
  }

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

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ResponseEntity<Event> update(@RequestBody Event event)
  {
    repository.save(event);
    return get(event.getId());
  }

  @RequestMapping
  public List<Event> all()
  {
    return repository.findAll();
  }
}
