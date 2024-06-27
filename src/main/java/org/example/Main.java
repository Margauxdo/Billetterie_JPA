package org.example;


import org.example.DAO.AddressDAO;
import org.example.DAO.ClientDAO;
import org.example.DAO.EventDAO;
import org.example.DAO.TicketDAO;
import org.example.entity.Address;
import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;
import org.example.util.IHM;
import org.example.util.Place;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {



        Address address = Address.builder()
                .street("rue de Paris")
                .city("Lille")
                .build();

        Client client = Client.builder()
                .name("Martin")
                .fullname("Anne")
                .address(Address.builder().build())
                .age(19)
                .phone("+0785623625")
                .build();

        Event event = Event.builder()
                .nameEvent("Main square")
                .addressEvent(Address.builder().build())
                .date(LocalDate.parse("2024-07-05"))
                .hour(LocalTime.parse("14:00"))
                .numberTicket(5)
                .build();

        Ticket ticket = Ticket.builder()
                .placeNumber(String.valueOf(6))
                .client(Client.builder().build())
                .event(Event.builder().build())
                .typeOfPlace(Place.valueOf("GOLD"))
                .build();


        IHM ihm = new IHM();
        ihm.start();


    }


}