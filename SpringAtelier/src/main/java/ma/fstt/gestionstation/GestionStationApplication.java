package ma.fstt.gestionstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.fstt.persistance")
@EnableJpaRepositories(basePackages = "ma.fstt.repo")
@ComponentScan(basePackages = "ma.fstt.services")
@ComponentScan(basePackages = "ma.fstt.controleurs")
public class GestionStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionStationApplication.class, args);
    }

}
