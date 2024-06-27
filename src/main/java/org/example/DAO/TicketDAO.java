package org.example.DAO;

import javax.persistence.EntityManager;

public class TicketDAO {

    private EntityManager em;

    public TicketDAO(EntityManager entityManager) {
        this.em = em;
    }
}
//c