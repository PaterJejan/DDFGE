package be.odisee.team5.meetup.meetupreservaties.service;

import be.odisee.team5.meetup.meetupreservaties.dao.ReservatieRepository;
import be.odisee.team5.meetup.meetupreservaties.domain.Reservatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class ReservatieServiceImpl implements ReservatieService{
    @Autowired
    ReservatieRepository repo;

    @Override
    public int processReservatie(Reservatie reservatie) {
       if (reservatie.getId() == 0){
            repo.save(reservatie);

       }else {
           try{
               Reservatie entity = repo.findById(reservatie.getId());
               entity.setDatum(reservatie.getDatum());
               entity.setEindtijdvergadering(reservatie.getEindtijdvergadering());
               entity.setDatumvergadering(reservatie.getDatumvergadering());
               entity.setReservator_id(reservatie.getReservator_id());
               entity.setStarttijdvergadering(reservatie.getStarttijdvergadering());
               entity.setStatus(reservatie.getStatus());
               entity.setLokaal_id(reservatie.getLokaal_id());

               repo.save(entity);
           }catch (Exception e){
               throw new NotFoundException();
           }
       }
       return reservatie.getId();
    }

    @Override
    public void deleteReservatie(int id) {
        try{
          repo.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException();
        }
    }

    @Override
    public Reservatie getDetailsReservatie(int id) {
        try{
           return repo.findById(id);
        }catch (Exception e){
            throw new NotFoundException();
        }
    }

    @Override
    public List<Reservatie> getAllReservaties() {
        return (List<Reservatie>) repo.findAll();
    }
}
