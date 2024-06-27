package org.example.DAO;

import org.example.entity.Address;
import org.example.entity.Event;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EventDAO {

    private EntityManager em;

    public EventDAO(EntityManager em)
    {
        this.em = em;
    }
    public void createEvent(Event event){
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
    }

    public void displayEvent(int id){

        Query query = em.createQuery("select e from Event e where e.id = :id",Event.class);
        query.setParameter("id",id);
        List<Event> events = query.getResultList();
        for(Event event : events){
            System.out.println(event);
        }
        try {
            Event event1 = em.find(Event.class,id);
            System.out.println(event1);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void updateEvent(Event event){

        try {
            em.getTransaction();
            em.merge(event);
            em.getTransaction().commit();
            System.out.println("event updated !");
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void deleteEvent(int id){

        try{
            em.getTransaction().begin();
            Event event = em.find(Event.class,id);
            if (event != null){
                em.remove(event);
                em.getTransaction().commit();
                System.out.println("Event deleted!!");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
