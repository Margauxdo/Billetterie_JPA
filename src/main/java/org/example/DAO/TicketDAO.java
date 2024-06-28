package org.example.DAO;

import org.example.entity.Address;
import org.example.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TicketDAO {

    private EntityManager em;

    public TicketDAO(EntityManager em) {
        this.em = em;
    }

    public void createTicket(Ticket ticket){
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
    }

    public void displayTicket(int id){

        Query query = em.createQuery("select t from Ticket t where t.id = :id",Ticket.class);
        query.setParameter("id",id);
        List<Ticket> tickets = query.getResultList();
        for(Ticket ticket : tickets){
            System.out.println(tickets);
        }
        try {
            Ticket ticket1 = em.find(Ticket.class,id);
            System.out.println(ticket1);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void updateTicket(Ticket ticket){

        try {
            em.getTransaction();
            em.merge(ticket);
            em.getTransaction().commit();
            System.out.println("ticket updated !");
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void deleteTicket(int id){

        try{
            em.getTransaction().begin();
            Ticket ticket = em.find(Ticket.class,id);
            if (ticket!= null){
                em.remove(ticket);
                em.getTransaction().commit();
                System.out.println("Ticket deleted!!");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
