package be.odisee.team5.meetup.meetupreservaties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MeetupReservatiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetupReservatiesApplication.class, args);
    }

}



