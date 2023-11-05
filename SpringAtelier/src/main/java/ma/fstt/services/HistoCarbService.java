package ma.fstt.services;

import ma.fstt.persistance.HistoCarb;
import ma.fstt.repo.HistoCarbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoCarbService {

    @Autowired
    private HistoCarbRepo histoCarbRepo;

    public List<HistoCarb> getAllHistoCarbs() {
        return histoCarbRepo.findAll();
    }

    public HistoCarb getHistoCarb(Long id) {
        return histoCarbRepo.findById(id).orElse(null);
    }

    public HistoCarb saveHistoCarb(HistoCarb histoCarb) {
        return histoCarbRepo.save(histoCarb);
    }

    public void deleteHistoCarb(Long id) {
        histoCarbRepo.deleteById(id);
    }

    public boolean exists(Long id) {
        return histoCarbRepo.existsById(id);
    }
}