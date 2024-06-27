package org.example.util;

import org.example.DAO.AddressDAO;
import org.example.DAO.ClientDAO;
import org.example.DAO.EventDAO;
import org.example.DAO.TicketDAO;
import org.example.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class IHM {

    //cree le menu pour les 4 possibilite 1. client : cree-afficher-modfier-supprimer
    //1. ticket : cree-afficher-modfier-supprimer
    //2. event : cree-afficher-modfier-supprimer
    //3. address : cree-afficher-modfier-supprimer
    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner sc;
    private AddressDAO addressDAO;
    private ClientDAO clientDAO;
    private EventDAO eventDAO;
    private TicketDAO ticketDAO;

    public IHM(EntityManager em, EntityManagerFactory emf){
        this.emf = Persistence.createEntityManagerFactory("billeterie");
        this.em = this.emf.createEntityManager();
        addressDAO = new AddressDAO(this.em);
        clientDAO = new ClientDAO(this.em);
        eventDAO = new EventDAO(this.em);
        ticketDAO = new TicketDAO(this.em);
        sc = new Scanner(System.in);
    }

    public void start (){
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



}
