package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("")
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id){
        if(!animals.containsKey(id)){
            System.out.println("This id doesn't exist");
        }
        return animals.get(id);
    }

    @PostMapping("")
    public void addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);

    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, new Animal(animal.getId(), animal.getName()));
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id){
        animals.remove(id);
    }



}
