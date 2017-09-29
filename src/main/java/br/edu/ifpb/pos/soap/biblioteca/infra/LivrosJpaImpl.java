/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.infra;

import br.edu.ifpb.pos.soap.biblioteca.model.Livro;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author kieckegard
 */

@Stateless
@Remote(Livros.class)
public class LivrosJpaImpl implements Livros {
    
    @PersistenceContext(unitName = "biblioteca-pu")
    private EntityManager manager;

    @Override
    public void add(Livro livro) {
        this.manager.persist(livro);
    }

    @Override
    public void remove(Livro livro) {
        Livro merged = this.manager.merge(livro);
        this.manager.remove(merged);
    }

    @Override
    public void update(Livro livro) {
        this.manager.merge(livro);
    }

    @Override
    public List<Livro> listAll() {
        System.out.println("[LivrosJpaImpl] listing all persisted books... ");
        TypedQuery<Livro> query = this.manager
                .createQuery("SELECT DISTINCT l FROM Livro l LEFT JOIN FETCH l.autores", Livro.class);
        List<Livro> livros = query.getResultList();
        livros.forEach(l -> System.out.println(l));
        return livros;
    }

    @Override
    public Livro findByIsbn(String isbn) {
        
        Livro found = this.manager.find(Livro.class, isbn);
        if(found != null)
            found.getAutores().size();
        return found;
    }
    
}
