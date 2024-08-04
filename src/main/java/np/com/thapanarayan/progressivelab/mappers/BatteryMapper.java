package np.com.thapanarayan.progressivelab.mappers;

import np.com.thapanarayan.progressivelab.dtos.BatteryDTO;
import np.com.thapanarayan.progressivelab.entities.Battery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatteryMapper {

    public List<Battery> toBatteryList(List<BatteryDTO> batteryDTOList) {
        return batteryDTOList.stream()
                .map(this::toBattery)
                .toList();
    }

    public Battery toBattery(BatteryDTO batteryDTO){
        Battery battery = new Battery();
        battery.setId(battery.getId());
        battery.setName(batteryDTO.getName());
        battery.setPostcode(batteryDTO.getPostcode());
        battery.setWattCapacity(batteryDTO.getWattCapacity());
        return battery;
    }

    public List<BatteryDTO> toBatteryDTOList(List<Battery> batteryList ) {
        return batteryList
                .stream()
                .map(this::toBatteryDTO)
                .toList();
    }

    public BatteryDTO toBatteryDTO(Battery battery) {
        return  BatteryDTO.builder()
                .id(battery.getId())
                .name(battery.getName())
                .postcode(battery.getPostcode())
                .wattCapacity(battery.getWattCapacity())
                .build();
    }
}
