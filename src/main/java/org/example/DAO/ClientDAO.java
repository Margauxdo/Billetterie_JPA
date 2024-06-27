package org.example.DAO;

import org.example.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClientDAO {
    private EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    public void createClient(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public void displayClient(int id) {
        Query query = em.createQuery("SELECT c FROM Client c WHERE c.id = :id", Client.class);
        query.setParameter("id", id);
        List<Client> clients = query.getResultList();
        for (Client client : clients) {
            System.out.println(client);
        }
        try {
            Client client1 = em.find(Client.class, id);
            System.out.println(client1);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void updateClient(Client client) {
        try {
            em.getTransaction();
            em.merge(client);
            em.getTransaction().commit();
            System.out.println("client updated");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteClient(int id) {

        try {
            em.getTransaction().begin();
            Client client = em.find(Client.class, id);
            if (client != null){
                em.remove(client);
                em.getTransaction().commit();
                System.out.println("client deleted");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
