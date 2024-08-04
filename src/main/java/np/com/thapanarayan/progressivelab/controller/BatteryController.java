package np.com.thapanarayan.progressivelab.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import np.com.thapanarayan.progressivelab.dtos.BatteryDTO;
import np.com.thapanarayan.progressivelab.dtos.ServerResponse;
import np.com.thapanarayan.progressivelab.entities.Battery;
import np.com.thapanarayan.progressivelab.mappers.BatteryMapper;
import np.com.thapanarayan.progressivelab.servies.BatteryService;
import org.apache.catalina.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/batteries")
public class BatteryController {

    private final BatteryService batteryService;
    private final BatteryMapper batteryMapper;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ServerResponse.class))
                    }
            )

    })
    public ResponseEntity<ServerResponse<?>> addBatteries(@RequestBody List<BatteryDTO> batteryDTOs) {

        List<Battery> batteries = batteryService.saveAllBatteries(batteryMapper.toBatteryList(batteryDTOs));
        var response = ServerResponse.builder()
                .success(true)
                .message("Batteries added successfully.")
                .data(batteryMapper.toBatteryDTOList(batteries))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ServerResponse.class))
                    }
            )

    })
    public ResponseEntity<ServerResponse<?>> getBatteriesByPostcodeRange(
            @RequestParam int startPostcode, @RequestParam int endPostcode) {

        List<Battery> batteries = batteryService.findBatteriesByPostcodeRange(startPostcode, endPostcode);

        List<String> batteryNames = batteries.stream()
                .map(Battery::getName)
                .sorted()
                .toList();

        int totalCapacity = batteries.stream()
                .mapToInt(Battery::getWattCapacity)
                .sum();

        double averageCapacity = batteries.stream()
                .mapToInt(Battery::getWattCapacity)
                .average()
                .orElse(0);

        Map<String, Object> responseMap = Map.of(
                "batteryNames", batteryNames,
                "totalCapacity", totalCapacity,
                "averageCapacity", averageCapacity
        );

        var response = ServerResponse.builder()
                .success(true)
                .message("Data fetch successfully")
                .data(responseMap)
                .build();

        return ResponseEntity.ok(response);
    }

}
