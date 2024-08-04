package np.com.thapanarayan.progressivelab.servies;

import lombok.RequiredArgsConstructor;
import np.com.thapanarayan.progressivelab.entities.Battery;
import np.com.thapanarayan.progressivelab.repositories.BatteryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryServicesImpl implements BatteryService {
    private final BatteryRepository batteryRepository;

    public List<Battery> saveAllBatteries(List<Battery> batteries) {
       batteryRepository.saveAll(batteries);
       return batteries;
    }

    public List<Battery> findBatteriesByPostcodeRange(int startPostcode, int endPostcode) {
        return batteryRepository.findByPostcodeBetweenOrderByNameAsc(startPostcode, endPostcode);
    }
}
