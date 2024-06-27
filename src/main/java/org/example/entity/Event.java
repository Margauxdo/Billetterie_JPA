package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="event_id")
    private int id;
    private String nameEvent;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address addressEvent;
    private LocalDate date;
    private LocalTime hour;
    private int numberTicket;

    @OneToMany(mappedBy = "id")//bidirectionnel, manytoone ca permet de l'avoir de l'autre cote avec mappedby
    private List<Ticket> ticketList;

}
