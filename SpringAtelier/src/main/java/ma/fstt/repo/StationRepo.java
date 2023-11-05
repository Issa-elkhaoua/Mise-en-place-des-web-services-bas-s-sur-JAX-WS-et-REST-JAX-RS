package ma.fstt.repo;

import ma.fstt.persistance.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo extends JpaRepository<Station, Long> {
}
