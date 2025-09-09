package com.ghamanager.persistencia;

import com.ghamanager.jpa.JPAUtil;
import jakarta.persistence.EntityManager;

public class EquipamentoDAO {
     public void cadastrar (Equipamento eqp){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(eqp);
            em.getTransaction().commit();            
        } catch (Exception e){
            em.getTransaction().rollback();
            throw e;        
        }finally {
            JPAUtil.closeEtityManager();
        }
    }
}
