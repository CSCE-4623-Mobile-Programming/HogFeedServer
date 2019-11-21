package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class HogFeedApplication
{
  @RequestMapping("/")
  @ResponseBody
  String home()
  {
    return "Welcome to HogFeed!";
  }

  public static void main(String[] args)
  {
    SpringApplication.run(HogFeedApplication.class, args);
  }
}
