package np.com.thapanarayan.progressivelab.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BatteryDTO {
    @Positive(message = "Id must be positive")
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Positive(message = "Valid Postcode is required")
    private int postcode;
    @NotBlank(message = "Watt Capacity is required")
    private int wattCapacity;
}
