package ma.fstt.controleurs;

import ma.fstt.persistance.HistoCarb;
import ma.fstt.services.HistoCarbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api3")
public class HistoCarbController {



    @Autowired
    private HistoCarbService histocarbService;

    @GetMapping("/histocarbs")
    public List<HistoCarb> getAllHistoCarbs() {
        return histocarbService.getAllHistoCarbs();
    }

    @GetMapping("/histocarbs/{id}")
    public HistoCarb getHistoCarb(@PathVariable Long id) {
        return histocarbService.getHistoCarb(id);
    }

    @PostMapping("/histocarbs")
    public HistoCarb createHistoCarb(@RequestBody HistoCarb histocarb) {
        return histocarbService.saveHistoCarb(histocarb);
    }

    @PutMapping("/histocarbs/{id}")
    public ResponseEntity<HistoCarb> updateHistoCarb(@PathVariable Long id, @RequestBody HistoCarb updatedHistoCarb) {
        if (!histocarbService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedHistoCarb.setId(id);
        HistoCarb savedHistoCarb = histocarbService.saveHistoCarb(updatedHistoCarb);
        return new ResponseEntity<>(savedHistoCarb, HttpStatus.OK);
    }

    @DeleteMapping("/histocarbs/{id}")
    public void deleteHistoCarb(@PathVariable Long id) {
        histocarbService.deleteHistoCarb(id);
    }
}


