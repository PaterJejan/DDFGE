package be.odisee.team5.meetup.meetuplogin.service;

import be.odisee.team5.meetup.meetuplogin.dao.PersoonRepository;
import be.odisee.team5.meetup.meetuplogin.domain.Persoon;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersoonServiceImpl implements PersoonService {

    @Autowired
    PersoonRepository persoonRepo;

    @Override
    public Persoon getPersoonDetailsById(int id) {
        return persoonRepo.findById(id);
    }

    @Override
    public Boolean checkCredentials(String wachtwoord, String gebruikersnaam) {
        Persoon persoon = persoonRepo.findByGebruikersnaam(gebruikersnaam);
       try{
           return persoon.getWachtwoord().equals(wachtwoord);
       }catch (Exception e){
           return false;
       }

    }

    @Override
    public int createPerson(Persoon persoon) {
        persoonRepo.save(persoon);
        return persoon.getId();
    }

    @Override
    public void deletePersoon(int id) throws NotFoundException {
        try{
            persoonRepo.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException("Persoon met $id niet gevonden");
        }
    }
}
