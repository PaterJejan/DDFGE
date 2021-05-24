package be.odisee.team5.meetup.meetupreservaties.controller;

import be.odisee.team5.meetup.meetupreservaties.domain.Reservatie;
import be.odisee.team5.meetup.meetupreservaties.service.ReservatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")//voorlopig all
public class ReservatieController {
    @Autowired
    ReservatieService service;

    @RequestMapping(path = "createReservatie"/*, method = RequestMethod.POST*/)
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservatie(@RequestBody Reservatie reservatie){
        service.processReservatie(reservatie);
    }

    @RequestMapping(path = "updateReservatie"/*, method = RequestMethod.POST*/)
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateReservatie(@RequestBody Reservatie reservatie){
        if (reservatie.getId() != 0){
            service.processReservatie(reservatie);
            return Response.status(200).encoding("Reservatie updated").build();
        }
        else{
            return Response.status(404).encoding("Reservatie not found").build();
        }
    }


    @RequestMapping (path = "deleteReservatie/{id}"/*, method = RequestMethod.DELETE*/)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response delete(@PathVariable("id") Integer id)  {
        try{
            service.deleteReservatie(id);
            return Response.status(200).build();
        }catch (NotFoundException e){

            return Response.status(404).encoding(e.getMessage()).build();
        }
    }

    @RequestMapping (path = "reservatie/{id}", method = RequestMethod.GET)
    Reservatie reservatie(@PathVariable("id") Integer id){
        return service.getDetailsReservatie(id);
    }

    @RequestMapping (path = "reservaties", method = RequestMethod.GET)
    public List<Reservatie> reservaties(){
        return service.getAllReservaties();
    }
}
