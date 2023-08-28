package pl.maja.service;

import org.springframework.stereotype.Service;
import pl.maja.model.MountainPeak;
import pl.maja.repository.MountainPeakRepository;

@Service
public class MountainPeakService {

    private MountainPeakRepository mountainPeakRepository;

    public MountainPeakService(MountainPeakRepository mountainPeakRepository) {
        this.mountainPeakRepository = mountainPeakRepository;
    }

    public MountainPeak getMountainPeakById(int id) {
        return this.mountainPeakRepository.getReferenceById(id);
    }

    public void addMountainPeak(MountainPeak mountainPeak) {
        mountainPeakRepository.save(mountainPeak);
    }
}




