/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ghamanager.ghamanager.gui;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author luann
 */
public class GhaManager {

    public static void main(String[] args) {
         try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            em.close();
            emf.close();
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }

