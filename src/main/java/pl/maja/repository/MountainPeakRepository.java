package pl.maja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maja.model.MountainPeak;
import pl.maja.model.User;

import java.util.List;

@Repository
public interface MountainPeakRepository extends JpaRepository<MountainPeak, Integer> {

    List<MountainPeak> findByUser(User user);
}
