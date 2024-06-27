package org.example.DAO;

import javax.persistence.EntityManager;

public class ClientDAO {
    private EntityManager em;

    public ClientDAO(EntityManager entityManager) {
        this.em = em;
    }
}
