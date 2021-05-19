package be.odisee.team5.meetup.meetupreservaties.dao;

import be.odisee.team5.meetup.meetupreservaties.domain.Reservatie;
import org.springframework.data.repository.CrudRepository;

public interface ReservatieRepository extends CrudRepository<Reservatie, Integer> {
    public Reservatie findById(int id);
}
