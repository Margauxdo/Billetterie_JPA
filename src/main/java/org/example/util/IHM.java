package org.example.util;

import org.example.DAO.AddressDAO;
import org.example.DAO.ClientDAO;
import org.example.DAO.EventDAO;
import org.example.DAO.TicketDAO;
import org.example.entity.Address;
import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class IHM {

    //cree le menu pour les 4 possibilite 1. client : cree-afficher-modfier-supprimer
    //1. ticket : cree-afficher-modfier-supprimer
    //2. event : cree-afficher-modfier-supprimer

    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner sc;
    private AddressDAO addressDAO;
    private ClientDAO clientDAO;
    private EventDAO eventDAO;
    private TicketDAO ticketDAO;







    public IHM(){
        this.emf = Persistence.createEntityManagerFactory("billeterie");
        this.em = this.emf.createEntityManager();
        addressDAO = new AddressDAO(this.em);
        clientDAO = new ClientDAO(this.em);
        eventDAO = new EventDAO(this.em);
        ticketDAO = new TicketDAO(this.em);
        sc = new Scanner(System.in);




    }


    public void start(){
        String entry;
        while (true){
            System.out.println("---Address Menu---");
            System.out.println("1/ Address");
            System.out.println("2/ Client ");
            System.out.println("3/ Event");
            System.out.println("4/ Ticket");
            entry = sc.nextLine();
            switch (entry){
                case "1"-> addressMenu();
                case "2"-> clientMenu();
                case "3"-> eventMenu();
                case "4"-> ticketMenu();
                default ->{
                    em.close();
                    emf.close();
                    return;

                }
            }
        }
    }

    private void addressMenu (){
        String entry;
        while (true){
            System.out.println("---Address Menu---");
            System.out.println("1/ Create address");
            System.out.println("2/ Display address ");
            System.out.println("3/ update address");
            System.out.println("4/delete address");
            entry = sc.nextLine();
            switch (entry){
                case "1"-> createAddress();
                case "2"-> displayAddress();
                case "3"-> updateAddress();
                case "4"-> deleteAddress();
                default ->{
                    return;

                }
            }
        }
    }

    private void clientMenu(){

        String entry;
        while (true){
            System.out.println("---Client Menu---");
            System.out.println("1/ Create client");
            System.out.println("2/ Display client ");
            System.out.println("3/ update client");
            System.out.println("4/delete client");
            entry = sc.nextLine();
            switch (entry){
                case "1"-> createClient();
                case "2"-> displayClient();
                case "3"-> updateClient();
                case "4"-> deleteClient();
                default ->{
                    return;

                }
            }
        }
    }

    private void eventMenu(){

        String entry;
        while (true){
            System.out.println("---CEvent Menu---");
            System.out.println("1/ Create event");
            System.out.println("2/ Display event ");
            System.out.println("3/ update event");
            System.out.println("4/delete event");
            entry = sc.nextLine();
            switch (entry){
                case "1"-> createEvent();
                case "2"-> displayEvent();
                case "3"-> updateEvent();
                case "4"-> deleteEvent();
                default ->{
                    return;

                }
            }
        }
    }

    private void ticketMenu(){

String entry;
        while (true){
            System.out.println("---Ticket Menu---");
            System.out.println("1/ Create ticket");
            System.out.println("2/ Display ticket ");
            System.out.println("3/ update ticket");
            System.out.println("4/delete ticket");
            entry = sc.nextLine();
            switch (entry){
                case "1"-> createTicket();
                case "2"-> displayTicket();
                case "3"-> updateTicket();
                case "4"-> deleteTicket();
                default ->{
                    return;

                }
            }
        }

    }

    public void createAddress (){
        System.out.println(" --- Add Address --- ");
        System.out.println(" street :");
        String street = sc.nextLine();

        System.out.println("city: ");
        String city = sc.nextLine();

        Address address = Address.builder().street(street).city(city).build();
        addressDAO.createAddress(address);
        System.out.println("create address" + address);
    }

    public void displayAddress (){
        System.out.println(" --- display address--- " );
        System.out.println("ID :");
        int id = sc.nextInt();
        //sc.nextLine();

        addressDAO.displayAddress(id);
    }

    public void updateAddress(){
        System.out.println(" --- update address --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();
        System.out.println("New Street : ");
        String street =  sc.nextLine();
        System.out.println("New city : ");
        String city = sc.nextLine();

        Address address = Address.builder().id(id).street(street).city(city).build();
        addressDAO.updateAddress(address);
    }

    public void deleteAddress (){
        System.out.println(" --- delete address --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();

        addressDAO.deleteAddress(id);


    }


    public void createClient (){
        System.out.println(" --- Add Client --- ");
        System.out.println(" name :");
        String name = sc.nextLine();
        System.out.println("fullname: ");
        String fullname = sc.nextLine();
        System.out.println("address street : ");
        String street =  sc.nextLine();
        System.out.println("address city : ");
        String city =  sc.nextLine();
        Address address = Address.builder().street(street).city(city).build();
        System.out.println(" client age : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println(age);
        System.out.println(" phone number : ");
        String phone =  sc.nextLine();
        System.out.println(phone);
        Client client = Client.builder().name(name).fullname(fullname).address(address).age(age).phone(phone).build();
        clientDAO.createClient(client);
        System.out.println("create client" + client);
    }

    public void displayClient (){
        System.out.println(" --- display client--- " );
        System.out.println("ID :");
        int id = sc.nextInt();

        clientDAO.displayClient(id);
    }

    public void updateClient(){
        System.out.println(" --- update client --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();
        System.out.println(" New name :");
        String name = sc.nextLine();
        System.out.println("New fullname: ");
        String fullname = sc.nextLine();
        System.out.println("New address street : ");
        String street =  sc.nextLine();
        System.out.println("New address city : ");
        String city =  sc.nextLine();
        Address address = Address.builder().street(street).city(city).build();
        System.out.println(" New client age : ");
        int age = sc.nextInt();
        System.out.println("New phone number : ");
        String phone =  sc.nextLine();
        Client client = Client.builder().name(name).fullname(fullname).address(address).age(age).phone(phone).build();
        clientDAO.createClient(client);

    }

    public void deleteClient (){
        System.out.println(" --- delete client --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();

        clientDAO.deleteClient(id);


    }



    public void createEvent (){
        System.out.println(" --- Add Event --- ");
        System.out.println(" name Event :");
        String nameEvent = sc.nextLine();
        System.out.println("address street : ");
        String street =  sc.nextLine();
        System.out.println("address city : ");
        String city =  sc.nextLine();
        Address address = Address.builder().street(street).city(city).build();
        System.out.println("date: ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("hour : ");
        LocalTime hour = LocalTime.parse(sc.nextLine());
        System.out.println("number ticket : ");
        int numberTicket = Integer.parseInt(sc.nextLine());

        Event event = Event.builder().nameEvent(nameEvent).date(date).hour(hour).numberTicket(numberTicket).build();
        eventDAO.createEvent(event);
        System.out.println("create event" + event);
    }

    public void displayEvent (){
        System.out.println(" --- display event--- " );
        System.out.println("ID :");
        int id = sc.nextInt();

        eventDAO.displayEvent(id);
    }

    public void updateEvent(){
        System.out.println(" --- update event --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();
        System.out.println(" New name Event :");
        String nameEvent = sc.nextLine();
        System.out.println("New address street : ");
        String street =  sc.nextLine();
        System.out.println("New address city : ");
        String city =  sc.nextLine();
        Address address = Address.builder().street(street).city(city).build();
        System.out.println("New date: ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("New hour : ");
        LocalTime hour = LocalTime.parse(sc.nextLine());
        System.out.println("New number ticket : ");
        int numberTicket = Integer.parseInt(sc.nextLine());

        Event event = Event.builder().nameEvent(nameEvent).date(date).hour(hour).numberTicket(numberTicket).build();
        eventDAO.createEvent(event);


    }

    public void deleteEvent (){
        System.out.println(" --- delete event --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();

        eventDAO.deleteEvent(id);


    }



    public void createTicket (){
        System.out.println(" --- Add Ticket--- ");
        System.out.println(" Number place :");
        String placeNumber = sc.nextLine();
        System.out.println(" name :");
        String name = sc.nextLine();
        System.out.println("fullname: ");
        String fullname = sc.nextLine();
        System.out.println("address street : ");
        String street =  sc.nextLine();
        System.out.println("address city : ");
        String city =  sc.nextLine();
        Address address = Address.builder().street(street).city(city).build();

        System.out.println(" client age : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println(age);
        System.out.println(" phone number : ");
        String phone =  sc.nextLine();
        Client client = Client.builder().name(name).fullname(fullname).address(address).age(age).phone(phone).build();
        System.out.println(" name Event :");
        String nameEvent = sc.nextLine();
        System.out.println("date: ");
        LocalDate dateEvent = LocalDate.parse(sc.nextLine());
        System.out.println("hour : ");
        LocalTime hourEvent = LocalTime.parse(sc.nextLine());
        Event event = Event.builder().nameEvent(nameEvent).build();
        Ticket ticket = Ticket.builder().placeNumber(placeNumber).client(client).event(event).build();
        ticketDAO.createTicket(ticket);
        System.out.println("create ticket" + ticket);
    }

    public void displayTicket (){
        System.out.println(" --- display ticket--- " );
        System.out.println("ID :");
        int id = sc.nextInt();

        ticketDAO.displayTicket(id);
    }

    public void updateTicket(){
        System.out.println(" --- update ticket --- ");
        System.out.println("ID : ");
        int id = sc.nextInt();
        System.out.println(" New Number place :");
        String placeNumber = sc.nextLine();
        System.out.println("New  name :");
        String name = sc.nextLine();
        System.out.println("New fullname: ");
        String fullname = sc.nextLine();
        System.out.println("New address street : ");
        String street =  sc.nextLine();
        System.out.println("New address city : ");
        String city =  sc.nextLine();
        Address address = Address.builder().street(street).city(city).build();
        System.out.println("New client age : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println(age);
        System.out.println("New phone number : ");
        String phone =  sc.nextLine();
        System.out.println(phone);
        Client client = Client.builder().name(name).fullname(fullname).address(address).age(age).phone(phone).build();
        System.out.println("New date: ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("New hour : ");
        LocalTime hour = LocalTime.parse(sc.nextLine());
        System.out.println("New number ticket : ");
        int numberTicket = Integer.parseInt(sc.nextLine());
        System.out.println("New name Event :");
        String nameEvent = sc.nextLine();
        System.out.println("New date: ");
        LocalDate dateEvent = LocalDate.parse(sc.nextLine());
        System.out.println("New hour : ");
        LocalTime hourEvent = LocalTime.parse(sc.nextLine());
        System.out.println("New number ticket : ");
        int numberTicketEvent = Integer.parseInt(sc.nextLine());
        Event event = Event.builder().nameEvent(nameEvent).date(date).hour(hour).numberTicket(numberTicket).build();
        System.out.println("New  type of place");
        Place typeOfPlace = Place.valueOf(sc.nextLine());
        Ticket ticket = Ticket.builder().placeNumber(placeNumber).client(client).event(event).typeOfPlace(typeOfPlace).build();
        ticketDAO.updateTicket(ticket);


    }

    public void deleteTicket (){
        System.out.println(" --- delete ticket--- ");
        System.out.println("ID : ");
        int id = sc.nextInt();

        ticketDAO.deleteTicket(id);


    }
}
