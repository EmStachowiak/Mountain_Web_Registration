package pl.maja.service;

import org.springframework.stereotype.Service;
import pl.maja.model.MountainPeak;
import pl.maja.model.User;
import pl.maja.repository.MountainPeakRepository;
import pl.maja.repository.RankingsDAO;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingsServiceImpl implements RankingsDAO {

    private MountainPeakRepository mountainPeakRepository;

    public RankingsServiceImpl(MountainPeakRepository mountainPeakRepository) {
        this.mountainPeakRepository = mountainPeakRepository;
    }

    @Override
    public int getNumberOfPeaksClimbedByUser(User user) {
        List<MountainPeak> peaksClimbedByUser = mountainPeakRepository.findByUser(user);
        return peaksClimbedByUser.size();
    }

    @Override
    public double getTotalDistanceClimbedByUser(User user) {
        List<MountainPeak> list = mountainPeakRepository.findByUser(user);
        double totalDistance = list.stream().collect(Collectors.summingDouble(MountainPeak::getDistance));
        return totalDistance;
    }

    @Override
    public int getTotalVerticalGainClimbedByUser(User user) {
        List<MountainPeak> list = mountainPeakRepository.findByUser(user);
        int totalVerticalGain = list.stream().collect(Collectors.summingInt(MountainPeak::getVerticalGain));
        return totalVerticalGain;
    }

    @Override
    public List<MountainPeak> getList3HighestPeaks(User user) {
        List<MountainPeak> list = mountainPeakRepository.findByUser(user);
        List<MountainPeak> listHighestPeaks = list.stream()
                .sorted(Comparator.comparingInt(MountainPeak::getHeight)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());
        return listHighestPeaks;
    }

    @Override
    public List<MountainPeak> list3GreatestVerticalGains(User user) {
        List<MountainPeak> list = mountainPeakRepository.findByUser(user);
        List<MountainPeak> listGreatestVerticalGains = list.stream()
                .sorted(Comparator.comparingInt(MountainPeak::getVerticalGain)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());

        return listGreatestVerticalGains;
    }

    @Override
    public List<MountainPeak> list3GreatestDistances(User user) {
        List<MountainPeak> list = mountainPeakRepository.findByUser(user);
        List<MountainPeak> listGreatestDistances = list.stream()
                .sorted(Comparator.comparingDouble(MountainPeak::getDistance)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());

        return listGreatestDistances;
    }

    @Override
    public List<MountainPeak> mostDifficultTrip(User user) {
        List<MountainPeak> list = mountainPeakRepository.findByUser(user);
        List<MountainPeak> mostDifficultTrip = list.stream()
                .sorted(Comparator.comparingInt(MountainPeak::getVerticalGain)
                        .thenComparingDouble(MountainPeak::getDistance)
                        .thenComparingInt(MountainPeak::getHeight)
                        .reversed())
                .limit(1)
                .collect(Collectors.toList());

        return mostDifficultTrip;
    }
}
