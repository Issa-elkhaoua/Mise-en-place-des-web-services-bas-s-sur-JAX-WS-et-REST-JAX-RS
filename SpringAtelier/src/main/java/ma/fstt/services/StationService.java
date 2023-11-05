package ma.fstt.services;

import ma.fstt.persistance.Station;
import ma.fstt.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationRepo stationRepo;

    public List<Station> getAllStations() {
        return stationRepo.findAll();
    }

    public Station getStation(Long id) {
        return stationRepo.findById(id).orElse(null);
    }

    public Station saveStation(Station station) {
        return stationRepo.save(station);
    }

    public void deleteStation(Long id) {
        stationRepo.deleteById(id);
    }

    public boolean exists(Long id) {
        return stationRepo.existsById(id);
    }
}
