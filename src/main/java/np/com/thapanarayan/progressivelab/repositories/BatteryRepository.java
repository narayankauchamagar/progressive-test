package np.com.thapanarayan.progressivelab.repositories;

import np.com.thapanarayan.progressivelab.entities.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

    List<Battery> findByPostcodeBetweenOrderByNameAsc(int postcode, int postcode2);
}
