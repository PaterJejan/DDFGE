package be.odisee.ddf.team5.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGatewayController {
    @GetMapping("/defaultFallbackReservaties")
    public String defaultMessageReservaties()
    {
        return "Er liep iets mis bij het connecteren naar de 'Reservatie' service, probeer later opnieuw.";
    }
    @GetMapping("/defaultFallbackLogin")
    public String defaultMessageLogin()
    {
        return "Er liep iets mis bij het connecteren naar de 'Login' service, probeer later opnieuw.";
    }
    @GetMapping("/defaultFallbackLoginL")
    public String defaultMessageLoginL()
    {
        return "Er liep iets mis bij het aanvragen van de inlog service service, probeer later opnieuw in te loggen.";
    }
    @GetMapping("/defaultFallbackLokalen")
    public String defaultMessageLokalen()
    {
        return "Er liep iets mis bij het connecteren met de 'Lokaal' service, probeer later opnieuw.";
    }
}
