package com.ghamanager.persistencia;

import com.ghamanager.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class EquipamentoDAO {

    //CRUD
    public void cadastrar(Equipamento eqp) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(eqp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public void alterarNoBanco(Equipamento eqp) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(eqp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
    //PESQUISAS

    public Equipamento buscarPorPatrimonio(String patrimonio) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Equipamento> query;
            query = em.createQuery("SELECT e FROM Equipamento e WHERE e.patrimonio = :patrimonio", Equipamento.class);
            query.setParameter("patrimonio", patrimonio);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
