package ma.fstt.controleurs;

import ma.fstt.persistance.Station;
import ma.fstt.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api1")
public class StationController {



    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/stations/{id}")
    public Station getStation(@PathVariable Long id) {
        return stationService.getStation(id);
    }

    @PostMapping("/stations")
    public Station createStation(@RequestBody Station station) {
        return stationService.saveStation(station);
    }

    @PutMapping("/stations/{id}")
    public ResponseEntity<Station> updateStation(@PathVariable Long id, @RequestBody Station updatedStation) {
        if (!stationService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedStation.setId(id);
        Station savedStation = stationService.saveStation(updatedStation);
        return new ResponseEntity<>(savedStation, HttpStatus.OK);
    }

    @DeleteMapping("/stations/{id}")
    public void deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
    }
}

