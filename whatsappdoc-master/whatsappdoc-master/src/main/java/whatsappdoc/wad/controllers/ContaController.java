package whatsappdoc.wad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import whatsappdoc.wad.models.perfil.Conta;
import whatsappdoc.wad.service.ContaServiceIF;

@RestController
@RequestMapping("/conta")   // http://localhost:8080/conta
public class ContaController {
    @Autowired
    private ContaServiceIF conta_Service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Conta> getAllConta() {return conta_Service.findAll();}
}
