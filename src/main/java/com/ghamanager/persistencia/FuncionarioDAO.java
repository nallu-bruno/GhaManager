package com.ghamanager.persistencia;

import com.ghamanager.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

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

    public Funcionario buscarPorId(String id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Funcionario> query;
            query = em.createQuery("SELECT m FROM Funcionario m WHERE m.id = :id", Funcionario.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Funcionario buscaFuncionarioCursosPorMatricula(String matricula) {

        EntityManager em = JPAUtil.getEntityManager();
        Funcionario funcionario = null;

        try {
            String jpql = "SELECT f FROM Funcionario f LEFT JOIN FETCH f.cursos WHERE f.matricula = :matricula";

            TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class).setParameter("matricula", matricula);
            funcionario = query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return funcionario;
    }

    public List<Funcionario> buscarTodosFuncionariosAtivos() {        

        EntityManager em = JPAUtil.getEntityManager();

        try {
            String jpql = "SELECT f FROM Funcionario f WHERE f.demitido = :demitido";
            TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);

            query.setParameter("demitido", "false");

            return query.getResultList();

        } catch (NoResultException e) {

            return Collections.emptyList(); // Retorna uma lista vazia e segura
        } finally {

            em.close();

        }
    }

}
