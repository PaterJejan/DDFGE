package be.odisee.team5.meetup.meetuplogin.service;

import be.odisee.team5.meetup.meetuplogin.domain.Persoon;
import javassist.NotFoundException;

public interface PersoonService {
    public Persoon getPersoonDetailsById(int id);
    public Boolean checkCredentials(String wachtwoord, String gebruikersnaam);
    public int createPerson(Persoon persoon);
    public void deletePersoon(int id) throws NotFoundException;
    public int getIdByGebruikersnaam(String gebuikersnaam);
    public void updatePersoon(Persoon persoon);
}
