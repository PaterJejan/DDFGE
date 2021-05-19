package be.odisee.team5.meetup.meetupreservaties.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author bramv
 * @version 1.0
 * @created 18-mei-2021 16:52:40
 */
@Entity
@Data
public class Reservatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate datum;
    private LocalDate datumvergadering;
    private LocalTime eindtijdvergadering;
    private int lokaal_id;
    private int reservator_id;
    private LocalTime starttijdvergadering;
    private int status;
    //public Lokalen lokaal;

    public Reservatie(){

    }


}