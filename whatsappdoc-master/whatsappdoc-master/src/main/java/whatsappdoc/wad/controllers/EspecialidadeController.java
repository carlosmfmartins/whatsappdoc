package whatsappdoc.wad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whatsappdoc.wad.models.perfil.Especialidade;
import whatsappdoc.wad.models.request.EspecialidadeRequestUpdate;
import whatsappdoc.wad.service.EspecialidadeServiceIF;

import javax.validation.Valid;

@RestController
@RequestMapping("/especialidade")   // localhost:8080/especialidade
public class EspecialidadeController {
    @Autowired
    private EspecialidadeServiceIF especialidade_Service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Especialidade> getAllEspecialidades() {return especialidade_Service.findAll();}

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Especialidade> getEspecialidade(@PathVariable Long id) {
        if (especialidade_Service.findEspecialidadeById(id) != null) {
            return new ResponseEntity<>(especialidade_Service.findEspecialidadeById(id), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Especialidade> createEspecialidade(@Valid @RequestBody Especialidade especialidade) {
        if (especialidade_Service.insertEspecialidade(especialidade)) {
            return new ResponseEntity<>(especialidade, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Especialidade> updateEspecialidade(@PathVariable Long id, @Valid @RequestBody EspecialidadeRequestUpdate especialidadeUpdateInfo) {
        Especialidade especialidadeUpdated = especialidade_Service.updateEspecialidade(id, especialidadeUpdateInfo);
        if (especialidadeUpdated != null) {
            return new ResponseEntity<>(especialidadeUpdated, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable Long id) {
        if (especialidade_Service.removeEspecialidade(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}
