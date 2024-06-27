package org.example;


import org.example.DAO.AddressDAO;
import org.example.DAO.ClientDAO;
import org.example.DAO.EventDAO;
import org.example.DAO.TicketDAO;
import org.example.entity.Address;
import org.example.util.IHM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("billeterie");
        EntityManager em = emf.createEntityManager();



        AddressDAO addressDAO = new AddressDAO(em);
        Address address = Address.builder()
                .street("rue de Paris")
                .city("Lille")
                .build();

        addressDAO.createAddress(address);
        addressDAO.displayAddress(address.getId());
        addressDAO.updateAddress(address);
        addressDAO.deleteAddress(address.getId());








        ClientDAO clientDAO = new ClientDAO(em);
        EventDAO eventDAO = new EventDAO(em);
        TicketDAO ticketDAO = new TicketDAO(em);


        new IHM(em,emf).start();
        em.close();
        emf.close();
        //
        //créé un objet avec builder + appeler les methodes
        //lancer IHM start
    }


}