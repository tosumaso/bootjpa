package com.example.bootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlienController{

  @Autowired
  private AlienRepository alienRepository;

  @GetMapping("/")
  public String input(Alien alien){
    return "home2";
  }

  @PostMapping("/add")
  public String addNewUser(@ModelAttribute @Validated Alien alien, BindingResult bindingResult){
    
    if (bindingResult.hasErrors()){
      return input(alien);
    }
    
    alienRepository.save(alien);
    return "saved";
  }

  @GetMapping("/all")
  public String getAllUsers(Model model){
    Iterable<Alien> alien = alienRepository.findAll();
    model.addAttribute("alien", alien);
    return "home3";
  }
}