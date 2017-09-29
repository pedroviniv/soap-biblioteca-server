/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.infra;

import br.edu.ifpb.pos.soap.biblioteca.model.Autor;
import java.util.List;

/**
 *
 * @author kieckegard
 */
public interface Autores {
    
    void add(Autor autor);
    void remove(Autor autor);
    List<Autor> listAll();
    void update(Autor autor);
    Autor findByEmail(String email);
}
