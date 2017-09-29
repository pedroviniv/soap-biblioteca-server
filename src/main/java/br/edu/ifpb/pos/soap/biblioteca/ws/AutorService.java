/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.ws;

import br.edu.ifpb.pos.soap.biblioteca.infra.Autores;
import br.edu.ifpb.pos.soap.biblioteca.model.Autor;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author kieckegard
 */

@WebService
public class AutorService {
    
    @EJB
    private Autores autores;
    
    @WebMethod(operationName = "addAutor")
    public void addAutor(@WebParam(name = "autor") Autor autor) {
        this.autores.add(autor);
    }
    
    @WebMethod(operationName = "removeAutor")
    public void removeAutor(@WebParam(name = "autorEmail") String email) {
        Autor autor = this.autores.findByEmail(email);
        this.autores.remove(autor);
    }
    
    @WebMethod(operationName = "updateAutor")
    public void updateAutor(@WebParam(name = "autorAtualizado") Autor autor) {
        this.autores.update(autor);
    }
    
    @WebMethod(operationName = "listAllAutores")
    public Autor[] listAllAutores() {
        return this.autores.listAll().toArray(new Autor[0]);
    }
}
