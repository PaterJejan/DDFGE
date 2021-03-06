package be.odisee.team5.meetup.meetuplogin.controller;

import be.odisee.team5.meetup.meetuplogin.domain.Persoon;
import be.odisee.team5.meetup.meetuplogin.service.PersoonService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@CrossOrigin( maxAge = 3600)
public class PersoonController {

    @Autowired
    PersoonService persoonService;

    @RequestMapping (path = "createPersoon", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public int createPersoon(@RequestBody Persoon persoon){
        persoonService.createPerson(persoon) ;
        return  persoon.getId();
    }

    @RequestMapping (path = "updatePersoon", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePersoon(@RequestBody Persoon persoon){
        persoonService.updatePersoon(persoon);
    }

    @RequestMapping (path = "deletePersoon/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response delete(@PathVariable("id") Integer id)  {
        try{
            persoonService.deletePersoon(id);
            return Response.status(200).build();
        }catch (NotFoundException e){

            return Response.status(404).encoding(e.getMessage()).build();
        }
    }

    @RequestMapping (path = "persoon/{id}", method = RequestMethod.GET)
    Persoon persoon(@PathVariable("id") Integer id){
        return persoonService.getPersoonDetailsById(id);
    }

    @RequestMapping (path = "login/{wachtwoord}/{gebruikersnaam}", method = RequestMethod.GET)
    public int  checkcredentials(@PathVariable("wachtwoord") String wachtwoord, @PathVariable("gebruikersnaam") String gebruikersnaam){
        if (persoonService.checkCredentials(wachtwoord, gebruikersnaam)){
            return persoonService.getIdByGebruikersnaam(gebruikersnaam);
        }
        else
            return 0;
    }
}
