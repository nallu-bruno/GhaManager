package com.ghamanager.persistencia;

import com.ghamanager.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.Optional;

public class UsuarioDAO {
     public Optional<Usuario> validarLogin(String login, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("usuario", login);
            query.setParameter("senha", senha);

            Usuario usuario = query.getSingleResult();
            return Optional.of(usuario); // encontrado

        } catch (NoResultException e) {
            return Optional.empty(); // não encontrou

        } finally {
            em.close();
        }
    }
}
