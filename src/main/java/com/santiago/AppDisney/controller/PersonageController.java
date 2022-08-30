package com.santiago.AppDisney.controller;

import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageDto;
import com.santiago.AppDisney.util.CustumerPage;
import com.santiago.AppDisney.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/characters")
@RestController
public class PersonageController {

    private final PersonageService personageService;

    @Autowired

    public PersonageController(PersonageService characterService) {
        this.personageService = characterService;
    }
    @PostMapping
    public PersonageBaseDto createCharacter(@RequestBody Personage personage){
        PersonageBaseDto characterDto1 = personageService.createCharacter(personage);
        return characterDto1;
    }

    @PutMapping("{id}")
    public PersonageBaseDto updatePersonage(@PathVariable Long id, @RequestBody Personage personage){
        return personageService.updatePersonage(id,personage);
    }
    @DeleteMapping("{id}")
    public String deletePersonage(@PathVariable Long id){
        return personageService.deletePersonage(id);
    }


    @GetMapping
    public ResponseEntity<CustumerPage> getAll(@RequestParam(required = false,defaultValue = "0") int page,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) Integer age
                                                  ){
      CustumerPage characteresPage =  personageService.getAllCharacter(page,name,age);
        return new ResponseEntity<>(characteresPage, HttpStatus.OK);
    }


}
