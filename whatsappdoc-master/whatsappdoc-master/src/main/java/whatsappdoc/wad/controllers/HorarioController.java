package whatsappdoc.wad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whatsappdoc.wad.models.calendario.Horario;
import whatsappdoc.wad.service.HorarioServiceIF;

import javax.validation.Valid;


@RestController
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    private HorarioServiceIF horario_Service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Horario> getAllHorarios(){
        return horario_Service.finAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Horario> getHorarios(@PathVariable Long id){
        if(horario_Service.getHorario(id) == null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(horario_Service.getHorario(id),HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> removeHorarios(@PathVariable Long id){
        if(horario_Service.removeHorario(id)){
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(path = "/{perfilId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Horario> createHorario(@PathVariable Long perfilId, @Valid @RequestBody Horario newHorario){
        if(horario_Service.insertHorario(perfilId, newHorario) == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            return new ResponseEntity<>(newHorario,HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/{perfilid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Horario> updateHorario(@PathVariable Long perfilId, @Valid @RequestBody Horario updateHorario){
        if(horario_Service.updateHorario(perfilId, updateHorario) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else{
            return new ResponseEntity<>(updateHorario,HttpStatus.ACCEPTED);
        }
    }



}
