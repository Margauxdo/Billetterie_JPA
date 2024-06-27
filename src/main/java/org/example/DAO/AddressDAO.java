package org.example.DAO;

import org.example.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AddressDAO{
    private EntityManager em;



    public AddressDAO(EntityManager em) {

        this.em = em;
    }

    public void createAddress(Address address){
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
    }

    public void displayAddress(int id){

        Query query = em.createQuery("select a from Address a where id = :id", Address.class);
        query.setParameter("id",id);
        List<Address> addressList = query.getResultList();
        for(Address address : addressList){
            System.out.println(address);
        }
        try {
            Address address1 = em.find(Address.class,id);
            System.out.println(address1);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void updateAddress(Address address){

        try {
            em.getTransaction();
            em.merge(address);
            em.getTransaction().commit();
            System.out.println("address updated !");
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void deleteAddress(int id){

        try{
            em.getTransaction().begin();
            Address address = em.find(Address.class,id);
            if (address != null){
                em.remove(address);
                em.getTransaction().commit();
                System.out.println("Address deleted!!");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
