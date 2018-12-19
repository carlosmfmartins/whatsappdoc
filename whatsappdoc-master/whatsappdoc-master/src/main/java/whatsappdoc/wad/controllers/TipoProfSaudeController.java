package whatsappdoc.wad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whatsappdoc.wad.models.perfil.TipoProfSaude;
import whatsappdoc.wad.service.TipoProfSaudeServiceIF;

import javax.validation.Valid;

@RestController
@RequestMapping("/tipoprofsaude")   // http://localhost:8080/tipoprofsaude
public class TipoProfSaudeController {
    @Autowired
    private TipoProfSaudeServiceIF tipoPS_Service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TipoProfSaude> getAllTipoProfSaude() {return tipoPS_Service.findAll();}

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoProfSaude> getTipoProfSaude(@PathVariable Long id) {
        if (tipoPS_Service.findTipoProfSaudeById(id) != null) {
            return new ResponseEntity<>(tipoPS_Service.findTipoProfSaudeById(id), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoProfSaude> createTipoProfSaude(@Valid @RequestBody TipoProfSaude tipoPS) {
        if (tipoPS_Service.insertTipoProfSaude(tipoPS)) {
            return new ResponseEntity<>(tipoPS, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTipoProfSaude(@PathVariable Long id) {
        if (tipoPS_Service.removeTipoProfSaude(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}
