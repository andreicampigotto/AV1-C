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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pgm4_andrei_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pgm4_andrei_pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", initialValue = 1)
    private Long id;
    
    @ManyToOne()
    Carro carro;

    private String nome;
    private String email;
    private Float peso;

    public Pessoa(Carro carro, String nome, String email, Float peso) {
        this.carro = carro;
        this.nome = nome;
        this.email = email;
        this.peso = peso;
    }

    public Pessoa(String nome, String email, Float peso) {
        this.nome = nome;
        this.email = email;
        this.peso = peso;
    }

    public Pessoa() {
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", peso=" + peso + '}';
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
