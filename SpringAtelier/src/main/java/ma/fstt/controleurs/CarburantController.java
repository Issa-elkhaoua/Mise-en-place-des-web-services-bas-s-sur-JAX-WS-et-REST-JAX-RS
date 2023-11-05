package ma.fstt.controleurs;

import ma.fstt.persistance.Carburant;
import ma.fstt.services.CarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api2")
public class CarburantController {

    @Autowired
    private CarburantService carburantService;

    @GetMapping("/carburants")
    public List<Carburant> getAllCarburants() {
        return carburantService.getAllCarbants();
    }

    @GetMapping("/carburants/{id}")
    public Carburant getCarburant(@PathVariable Long id) {
        return carburantService.getCarburant(id);
    }

    @PostMapping("/carburants")
    public Carburant createCarburant(@RequestBody Carburant carburant) {
        return carburantService.saveCarburant(carburant);
    }

    @PutMapping("/carburants/{id}")
    public ResponseEntity<Carburant> updateCarburant(@PathVariable Long id, @RequestBody Carburant updatedCarburant) {
        if (!carburantService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedCarburant.setId(id);
        Carburant savedCarburant = carburantService.saveCarburant(updatedCarburant);
        return new ResponseEntity<>(savedCarburant, HttpStatus.OK);
    }

    @DeleteMapping("/carburants/{id}")
    public void deleteCarburant(@PathVariable Long id) {
        carburantService.deleteCarburant(id);
    }
}


