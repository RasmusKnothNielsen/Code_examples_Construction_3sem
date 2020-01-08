package com.example.demo.api.controller;

import com.example.demo.api.model.Cat;
import com.example.demo.api.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class CatControllerUsingRepository {

    @Autowired
    CatRepository catRepository;

    // GET request returning a list of Cats from the database
    @GetMapping("/cat")
    public Iterable<Cat> getListOfCats() {
        // use the CrudRepository method to iterate through the cat table
        return catRepository.findAll();
    }

    // Find specific cat by name
    @GetMapping("/findcat")
    public Iterable<Cat> getOneCat(@RequestParam(value = "name") String name) {
        return catRepository.findByName(name);
    }


    // POST request adding a new cat to the database
    @PostMapping("/cat")
    public Cat addNewCat(@RequestBody Cat cat) {
        // use the CrudRepository method to save a cat to the cat table
        return catRepository.save(cat);
    }

    // PUT request to change a cat in the database
    @PutMapping("/cat/{name}")
    public String updateCat(@PathVariable String name, @RequestBody Cat cat) {
        // use the Crudrepository to update a cat in the cat table
        Iterable<Cat> foundCat = catRepository.findByName(name);
        if (foundCat != null) {
            if (catRepository.countByName(name) < 1) {
                return "No cat named: " + name + " in table cat";
            } else if (catRepository.countByName(name) > 1) {
                return "More than one cat named: " + name + " in table cat, please request by Id instead of name";
            } else {
                Cat newCat = catRepository.findCatByName(name);
                newCat.setName(cat.getName());
                catRepository.save(newCat);
                return "Cat updated";
            }
        } else {
            return "Cat not found";
        }
    }

    // DELETE request removing a cat from the database
    @Transactional
    @DeleteMapping("/cat/{name}")
    public String deleteCatFromDB(@PathVariable String name) {
        Iterable<Cat> foundCat = catRepository.findByName(name);
        if (foundCat != null) {
            if (catRepository.countByName(name) < 1) {
                return "No cat named: " + name + " in table cat";
            } else if (catRepository.countByName(name) > 1) {
                return "More than one cat named: " + name + " in table cat, please request by Id instead of name";
            } else {
                catRepository.deleteByName(name);
                return "Cat deleted";
            }
        } else {
            return "Cat not found";
        }
    }

}
