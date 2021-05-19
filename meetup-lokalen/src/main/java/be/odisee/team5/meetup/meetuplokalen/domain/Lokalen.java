package be.odisee.team5.meetup.meetuplokalen.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author bramv
 * @version 1.0
 * @created 18-mei-2021 16:52:40
 */
@Entity
@Data

public class Lokalen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int capaciteit;
    private String gebouw;
    private boolean hapje;

    private boolean koffiemachine;
    private String lokaalnaam;
    private boolean projector;
    private int verdieping;
    private boolean wifi;

    public Lokalen() {

    }

}

