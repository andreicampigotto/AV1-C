/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.av1.c.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author andre
 */

@Entity
@Table(name = "pgm4_andrei_carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pgm4_andrei_carro_seq")
    @SequenceGenerator(name = "carro_seq", initialValue = 1)
    private Long id;
    
    @OneToMany(mappedBy="carro", cascade = CascadeType.ALL)
    Set<Pessoa> pessoas = new HashSet<>();

    private String nome;
    
     public Carro(String nome) {
        this.nome = nome;
    }

    public Carro() {
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set pessoas) {
        this.pessoas = pessoas;
    }
}
