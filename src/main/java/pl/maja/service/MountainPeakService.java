package pl.maja.service;

import org.springframework.stereotype.Service;
import pl.maja.model.MountainPeak;
import pl.maja.model.User;
import pl.maja.repository.MountainPeakRepository;

import java.util.List;

@Service
public class MountainPeakService {

    private MountainPeakRepository mountainPeakRepository;

    public MountainPeakService(MountainPeakRepository mountainPeakRepository) {
        this.mountainPeakRepository = mountainPeakRepository;
    }

    public void addMountainPeak(MountainPeak mountainPeak) {
        mountainPeakRepository.save(mountainPeak);
    }

    public List<MountainPeak> showAllTrips(User user) { // ?????????????
        return this.mountainPeakRepository.findByUser(user);
    }

    public MountainPeak getMountainPeakById(int id) {
        return this.mountainPeakRepository.getReferenceById(id);
    }


}




