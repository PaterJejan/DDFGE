package be.odisee.team5.meetup.meetuplokalen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MeetupLokalenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetupLokalenApplication.class, args);
    }

}
