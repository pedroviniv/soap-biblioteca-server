/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.biblioteca.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kieckegard
 */

@XmlRootElement
@Entity
public class Autor implements Serializable {
    
    @Id
    private String email;
    private String nome;
    private String abreviacao;

    public Autor(String email, String nome, String abreviacao) {
        this.email = email;
        this.nome = nome;
        this.abreviacao = abreviacao;
    }

    public Autor() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    @Override
    public String toString() {
        return "Autor{" + "email=" + email + ", nome=" + nome + ", abreviacao=" + abreviacao + '}';
    }
}
