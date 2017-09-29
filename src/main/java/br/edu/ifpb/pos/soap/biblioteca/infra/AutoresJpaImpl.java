/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.infra;

import br.edu.ifpb.pos.soap.biblioteca.model.Autor;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author kieckegard
 */

@Stateless
@Local(Autores.class)
public class AutoresJpaImpl implements Autores {
    
    @PersistenceContext(unitName = "biblioteca-pu")
    private EntityManager manager;
    
    @Override
    public void add(Autor autor) {
        this.manager.persist(autor);
    }

    @Override
    public void remove(Autor autor) {
        Autor merged = this.manager.merge(autor);
        this.manager.remove(merged);
    }

    @Override
    public List<Autor> listAll() {
        TypedQuery<Autor> query = this.manager
                .createQuery("SELECT a FROM Autor a", Autor.class);
        return query.getResultList();
    }

    @Override
    public void update(Autor autor) {
        this.manager.merge(autor);
    }

    @Override
    public Autor findByEmail(String email) {
        return this.manager.find(Autor.class, email);
    }
    
    
}
