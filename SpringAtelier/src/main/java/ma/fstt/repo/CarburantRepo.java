package ma.fstt.repo;

import ma.fstt.persistance.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepo extends JpaRepository<Carburant, Long> {
}
