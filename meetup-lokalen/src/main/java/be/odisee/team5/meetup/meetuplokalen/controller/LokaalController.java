package be.odisee.team5.meetup.meetuplokalen.controller;

import be.odisee.team5.meetup.meetuplokalen.domain.Lokalen;
import be.odisee.team5.meetup.meetuplokalen.service.LokaalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class LokaalController {
    @Autowired
    LokaalService service;

    @RequestMapping(path = "createLokaal", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservatie(@RequestBody Lokalen lokalen){
        service.processLokaal(lokalen);
    }

    @RequestMapping (path = "deleteLokaal/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response delete(@PathVariable("id") Integer id)  {
        try{
            service.deleteLokaal(id);
            return Response.status(200).build();
        }catch (NotFoundException e){

            return Response.status(404).encoding(e.getMessage()).build();
        }
    }

    @RequestMapping(path = "updateLokaal", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateReservatie(@RequestBody Lokalen lokalen){
        if (lokalen.getId() != 0){
            service.processLokaal(lokalen);
            return Response.status(200).encoding("Lokaal updated").build();
        }
        else{
            return Response.status(404).encoding("lokaal not found").build();
        }
    }

    @RequestMapping (path = "lokaal/{id}", method = RequestMethod.GET)
    Lokalen lokaal(@PathVariable("id") Integer id){
        return service.getDetailsLokaal(id);
    }

    @RequestMapping (path = "lokalen", method = RequestMethod.GET)
    public List<Lokalen> lokalen(){
        return service.getAllLokalen();
    }
}





