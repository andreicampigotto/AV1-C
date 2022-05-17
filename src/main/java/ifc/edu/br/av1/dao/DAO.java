/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.av1.dao;

import ifc.edu.br.av1.c.model.Carro;
import ifc.edu.br.av1.c.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author andre
 */
public class DAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }
    
    public void inserirPessoa(Pessoa p) {
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(p);
        tx.commit();
    }
    
    public List consultarPessoas() {
        List pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
        return pessoas;
    }
    
    public void inserirCarro(Carro c) {
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(c);
        tx.commit();
    }
    
    public List consultarCarros() {
        List carros = em.createQuery("from Carro", Carro.class).getResultList();
        return carros;
    }
    
    public Carro consultarCarro(Long id) {
        Query q = em.createQuery("from Carro where id = :id", Carro.class);
        q.setParameter("id", id);
        return (Carro) q.getSingleResult();
    }
    
}