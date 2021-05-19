package be.odisee.team5.meetup.meetuplokalen.service;

import be.odisee.team5.meetup.meetuplokalen.dao.LokaalRepository;
import be.odisee.team5.meetup.meetuplokalen.domain.Lokalen;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LokaalServiceImpl implements LokaalService{

    @Autowired
    LokaalRepository repo;

    @Override
    public int processLokaal(Lokalen lokaal) {

        if(lokaal.getId() == 0){
            repo.save(lokaal);
        }
        else {
            Lokalen entity = repo.findById(lokaal.getId());
            entity.setWifi(lokaal.isWifi());
            entity.setCapaciteit(lokaal.getCapaciteit());
            entity.setGebouw(lokaal.getGebouw());
            entity.setLokaalnaam(lokaal.getLokaalnaam());
            entity.setHapje(lokaal.isHapje());
            entity.setProjector(lokaal.isProjector());
            entity.setKoffiemachine(lokaal.isKoffiemachine());
            entity.setVerdieping(lokaal.getVerdieping());

            repo.save(entity);

        }
        return lokaal.getId();
    }

    @Override
    public void deleteLokaal(int id) {
        repo.deleteById(id);
    }

    @Override
    public Lokalen getDetailsLokaal(int id) {
        return repo.findById(id);
    }

    @Override
    public List<Lokalen> getAllLokalen() {
        return (List<Lokalen>) repo.findAll();
    }
}
