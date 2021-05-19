package be.odisee.team5.meetup.meetuplokalen.dao;

import be.odisee.team5.meetup.meetuplokalen.domain.Lokalen;
import org.springframework.data.repository.CrudRepository;

public interface LokaalRepository extends CrudRepository<Lokalen, Integer>  {

    public  Lokalen findById(int id);
}
