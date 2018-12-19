package whatsappdoc.wad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whatsappdoc.wad.models.perfil.ProfSaude;
import whatsappdoc.wad.models.request.ProfSaudeRequest;
import whatsappdoc.wad.models.request.ProfSaudeRequestUpdate;
import whatsappdoc.wad.service.ProfSaudeServiceIF;

import javax.validation.Valid;

@RestController
@RequestMapping("/profssaude") // http://localhost:8080/profssaude
public class ProfSaudeController {
    @Autowired
    private ProfSaudeServiceIF profSaude_Service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Iterable<ProfSaude> getAllProfSaude() {return profSaude_Service.findAll();}

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfSaude> getProfSaude(@PathVariable Long id) {
        if (profSaude_Service.findProfSaudeById(id) != null) {
            return new ResponseEntity<>(profSaude_Service.findProfSaudeById(id), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProfSaude> createProfSaude(@Valid @RequestBody ProfSaudeRequest profSaudeRequest) {
        ProfSaude profSaude = profSaude_Service.insertProfSaude(profSaudeRequest);
        if (profSaude != null) {
            return new ResponseEntity<>(profSaude, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfSaude> updateProfSaude(@PathVariable Long id, ProfSaudeRequestUpdate psUpdateInfo) {
        ProfSaude psUpdated = profSaude_Service.updateProfSaude(id, psUpdateInfo);
        if (psUpdated != null) {
            return new ResponseEntity<>(psUpdated, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProfSaude(@PathVariable Long id) {
        if (profSaude_Service.removeProfSaude(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}