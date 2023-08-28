package pl.maja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maja.model.MountainPeak;

@Repository
public interface MountainPeakRepository extends JpaRepository<MountainPeak, Integer> {
}
