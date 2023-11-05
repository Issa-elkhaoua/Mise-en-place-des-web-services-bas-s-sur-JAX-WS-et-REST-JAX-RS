package ma.fstt.services;

import ma.fstt.persistance.Carburant;
import ma.fstt.repo.CarburantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarburantService {
    @Autowired
    private CarburantRepo carburantRepo;

    public List<Carburant> getAllCarbants() {
        return carburantRepo.findAll();
    }

    public Carburant getCarburant(Long id) {
        return carburantRepo.findById(id).orElse(null);
    }

    public Carburant saveCarburant(Carburant carburant) {
        return carburantRepo.save(carburant);
    }

    public void deleteCarburant(Long id) {
        carburantRepo.deleteById(id);
    }

    public boolean exists(Long id) {
        return carburantRepo.existsById(id);
    }
}