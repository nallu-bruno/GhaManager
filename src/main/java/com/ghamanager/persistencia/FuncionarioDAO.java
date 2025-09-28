package com.ghamanager.persistencia;

import com.ghamanager.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FuncionarioDAO {
    
    //CRUD
     public void cadastrar(Funcionario func) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public void alterarNoBanco(Funcionario func) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(func);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
    
     //PESQUISAS

    public Funcionario buscarPorMatricula(String matricula) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Funcionario> query;
            query = em.createQuery("SELECT m FROM Funcionario m WHERE m.matricula = :matricula", Funcionario.class);
            query.setParameter("matricula", matricula);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
