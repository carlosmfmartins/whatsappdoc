package whatsappdoc.wad.service;

import whatsappdoc.wad.models.perfil.Conta;

public interface ContaServiceIF {
    Iterable<Conta> findAll();
}
