package be.odisee.team5.meetup.meetuplogin.dao;

import be.odisee.team5.meetup.meetuplogin.domain.Persoon;
import org.springframework.data.repository.CrudRepository;

public interface PersoonRepository  extends CrudRepository<Persoon, Integer> {
    public  Persoon findById(int id);
    public Persoon findByGebruikersnaam(String gebruikersnaam);
}
