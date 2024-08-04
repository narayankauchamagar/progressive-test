package np.com.thapanarayan.progressivelab.servies;

import np.com.thapanarayan.progressivelab.entities.Battery;

import java.util.List;

public interface BatteryService {
    List<Battery> saveAllBatteries(List<Battery> batteries) ;
    List<Battery> findBatteriesByPostcodeRange(int startPostcode, int endPostcode);
}
