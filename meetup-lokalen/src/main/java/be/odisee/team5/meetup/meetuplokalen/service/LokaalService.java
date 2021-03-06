package be.odisee.team5.meetup.meetuplokalen.service;

import be.odisee.team5.meetup.meetuplokalen.domain.Lokalen;

import java.util.List;

public interface LokaalService {
    /**
     * update en creat van een lokaal
     * @param lokaal
     * @return
     */
    public int processLokaal(Lokalen lokaal);
    public void deleteLokaal(int id);
    public Lokalen getDetailsLokaal(int id);
    public List<Lokalen> getAllLokalen();
}
