package com.ghamanager.persistencia;

import com.ghamanager.jpa.JPAUtil;
import jakarta.persistence.EntityManager;

public class CursoDAO {
    
    public void adicionarCurso(Curso curso){        
    EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    
    }
    
}
