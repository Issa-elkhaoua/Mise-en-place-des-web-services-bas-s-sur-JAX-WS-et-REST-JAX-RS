package ma.fstt.repo;

import ma.fstt.persistance.HistoCarb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoCarbRepo extends JpaRepository<HistoCarb, Long> {
}
