package be.odisee.team5.meetup.meetuplogin;

import be.odisee.team5.meetup.meetuplogin.dao.PersoonRepository;
import be.odisee.team5.meetup.meetuplogin.domain.Persoon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@SpringBootApplication
public class MeetupLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetupLoginApplication.class, args);
    }


    @Bean
    CommandLineRunner init (PersoonRepository repository){

        Persoon p = new Persoon();
        p.setRol("ROLE_USER");
        p.setGebruikersnaam("Jef");
        p.setWachtwoord("12345");


        Persoon admin = new Persoon();
        admin.setRol("ROLE_ADMIN");
        admin.setGebruikersnaam("admin");
        admin.setWachtwoord("admin");


        return (evt) -> {repository.save(p);repository.save(admin);};

    }
}
