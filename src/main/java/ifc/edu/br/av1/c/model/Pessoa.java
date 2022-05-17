/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.av1.c.model;

/**
 *
 * @author andre
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pgm4_andrei_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_andrei_pessoa_seq")
    @SequenceGenerator(name = "pgm4_andrei_pessoa_seq", initialValue = 1)
            
    long id;
    String nome;
    String email;
    float peso;
    
    public Pessoa(long id, String nome, String email, float peso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.peso = peso;
    }

       public Pessoa(String nome, String email, float peso) {
        this.nome = nome;
        this.email = email;
        this.peso = peso;
    }
       

    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", peso=" + peso + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
