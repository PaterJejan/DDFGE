package be.odisee.team5.meetup.meetupreservaties;

import be.odisee.team5.meetup.meetupreservaties.domain.Reservatie;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

public class RepositoryConfig implements RepositoryRestConfigurer {
    /**
     * Zorgt ervoor dat we de id meekrijgen als we een object raadplegen uit de database
     * @param config
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Reservatie.class);
    }

}
