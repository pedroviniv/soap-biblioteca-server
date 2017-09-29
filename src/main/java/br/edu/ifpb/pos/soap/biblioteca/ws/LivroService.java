/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.ws;

import br.edu.ifpb.pos.soap.biblioteca.infra.Autores;
import br.edu.ifpb.pos.soap.biblioteca.infra.Livros;
import br.edu.ifpb.pos.soap.biblioteca.model.Autor;
import br.edu.ifpb.pos.soap.biblioteca.model.Livro;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author kieckegard
 */

@WebService
public class LivroService {
    
    @EJB
    private Livros livros;
    @EJB
    private Autores autores;
    
    
    @WebMethod(operationName = "addLivro")
    public void addLivro(@WebParam(name = "livro") Livro livro) {
        this.livros.add(livro);
    }
    
    @WebMethod(operationName = "bindAutor")
    public void bindAutor(
            @WebParam(name = "livroIsbn") String isbn, 
            @WebParam(name = "autorEmail") String email) {
        Livro livro = this.livros.findByIsbn(isbn);
        Autor autor = this.autores.findByEmail(email);
        livro.addAutor(autor);
        this.livros.update(livro);
    }
    
    @WebMethod(operationName = "unbindAutor")
    public void unbindAutor(
            @WebParam(name = "livroIsbn") String isbn, 
            @WebParam(name = "autorEmail") String email) {
        Livro livro = this.livros.findByIsbn(isbn);
        livro.removeAutor(email);
        this.livros.update(livro);
    }
    
    @WebMethod(operationName = "removeLivro")
    public void remove(@WebParam(name = "livro") String isbn) {
        Livro found = this.livros.findByIsbn(isbn);
        this.livros.remove(found);
    }
    
    @WebMethod(operationName = "updateLivro")
    public void update(@WebParam(name = "livroAtualizado") Livro livro) {
        this.livros.update(livro);
    }
    
    @WebMethod(operationName = "listAllLivros")
    public Livro[] listAllLIvros() {
        return this.livros.listAll().toArray(new Livro[0]);
    }
}
