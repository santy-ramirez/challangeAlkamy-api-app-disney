package com.santiago.AppDisney.controller;

import com.santiago.AppDisney.domain.Personage;
import com.santiago.AppDisney.dto.personage.PersonageBaseDto;
import com.santiago.AppDisney.dto.personage.PersonageDto;
import com.santiago.AppDisney.dto.personage.PersonageQueryDto;
import com.santiago.AppDisney.util.CustumerPage;
import com.santiago.AppDisney.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Validated
@RequestMapping("api/v1/characters")
@RestController
public class PersonageController {

    private final PersonageService personageService;

    @Autowired

    public PersonageController(PersonageService personageService) {
        this.personageService = personageService;
    }
    @PostMapping
    public ResponseEntity<PersonageQueryDto>  createCharacter(@RequestBody @Valid PersonageQueryDto personage){
        PersonageQueryDto personageDto = personageService.createCharacter(personage);
        return new ResponseEntity<>(personageDto,HttpStatus.CREATED) ;
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonageQueryDto>  updatePersonage(@PathVariable Long id, @RequestBody @Valid PersonageQueryDto personage){
        return new ResponseEntity<>(personageService.updatePersonage(id,personage),HttpStatus.OK) ;
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>  deletePersonage(@PathVariable Long id){
        return new ResponseEntity<>(personageService.deletePersonage(id),HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<CustumerPage> getAll(@RequestParam(required = false,defaultValue = "0") @Valid @Positive int page,
                                               @RequestParam(required = false) @Valid @Size(min = 3, max = 20) String name,
                                               @RequestParam(required = false) Integer age
                                                  ){
      CustumerPage personages =  personageService.getAllPersonages(page,name,age);
        return new ResponseEntity<>(personages, HttpStatus.OK);
    }


}
