package pl.maja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maja.model.MountainPeak;
import pl.maja.model.User;

import java.util.List;

@Repository
public interface RankingsDAO {

    public int getNumberOfPeaksClimbedByUser(User user);
    public double getTotalDistanceClimbedByUser(User user);
    public int getTotalVerticalGainClimbedByUser(User user);

    public List<MountainPeak> getList3HighestPeaks(User user);
    public List<MountainPeak> list3GreatestVerticalGains(User user);
    public List<MountainPeak> list3GreatestDistances(User user);
    public List<MountainPeak> mostDifficultTrip(User user);


}
