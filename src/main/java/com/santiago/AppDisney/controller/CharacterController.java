package com.santiago.AppDisney.controller;

import com.santiago.AppDisney.domain.Characters;
import com.santiago.AppDisney.dto.characters.CharacterBaseDto;
import com.santiago.AppDisney.dto.characters.CharacterDto;
import com.santiago.AppDisney.dto.characters.CharacteresPage;
import com.santiago.AppDisney.repository.CharacterRepository;
import com.santiago.AppDisney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/characters")
@RestController
public class CharacterController {
    @Autowired
    private CharacterRepository characterRepository;
    private final CharacterService characterService;

    @Autowired

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
    @PostMapping
    public CharacterBaseDto createCharacter(@RequestBody CharacterBaseDto characterDto){
        CharacterBaseDto characterDto1 = characterService.createCharacter(characterDto);
        return characterDto1;
    }

    @GetMapping
    public ResponseEntity<CharacteresPage> getAll(@RequestParam(required = false,defaultValue = "0") int page,
                                                  @RequestParam(required = false) String prefix
                                                  ){
      CharacteresPage characteresPage =  characterService.getAllCharacter(page,prefix);
        return new ResponseEntity<>(characteresPage, HttpStatus.OK);
    }

    @GetMapping("hola")
    public Page getName(@RequestParam(name = "page" ,required = false,defaultValue = "0") int page,
                        @RequestParam(name = "prefix",required = false) String name
                        ){
        return characterService.getForName(page,name);
    }

    @GetMapping("hola2")
    public List<CharacterBaseDto> getnamenaw(@RequestParam(name = "name")String name){
        return characterService.getlistname(name);
    }
    @GetMapping("hola3")
        public List<Characters> getentity(
               @RequestParam(name = "name" ,required = false) String name
                ){
                       return characterRepository.findByName(name);
        }
}
