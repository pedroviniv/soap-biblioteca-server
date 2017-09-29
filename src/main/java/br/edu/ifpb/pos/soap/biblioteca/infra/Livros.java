/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.infra;

import br.edu.ifpb.pos.soap.biblioteca.model.Livro;
import java.util.List;

/**
 *
 * @author kieckegard
 */
public interface Livros {
    
    void add(Livro livro);
    void remove(Livro livro);
    void update(Livro livro);
    Livro findByIsbn(String isbn);
    List<Livro> listAll();
    
}
