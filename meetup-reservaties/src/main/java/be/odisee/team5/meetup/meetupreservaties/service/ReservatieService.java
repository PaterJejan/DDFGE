package be.odisee.team5.meetup.meetupreservaties.service;

import be.odisee.team5.meetup.meetupreservaties.domain.Reservatie;

import java.util.List;


public interface ReservatieService {
    /**
     * update en create van een reservatie
     * @param reservatie
     * @return id from created or updated lokaal
     */
    public int processReservatie(Reservatie reservatie);
    public void deleteReservatie(int id);
    public Reservatie getDetailsReservatie(int id);
    public List<Reservatie> getAllReservaties();
}



