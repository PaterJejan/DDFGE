package be.odisee.team5.meetup.meetuplogin;

import be.odisee.team5.meetup.meetuplogin.domain.Persoon;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

    /**
     * Zorgt ervoor dat we de id meekrijgen als we een object raadplegen uit de database
     * @param config
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Persoon.class);
    }

}
