package com.vehicle.vehiclerental.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.vehicle.vehiclerental.dto.VehicleDTO;
import com.vehicle.vehiclerental.entity.Vehicle;
import com.vehicle.vehiclerental.mapper.VehicleMapper;
import com.vehicle.vehiclerental.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "http://localhost:5173")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles()
                .stream()
                .map(VehicleMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);
        return VehicleMapper.toDTO(vehicle);
    }

    @PostMapping
    public VehicleDTO addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDTO);
        Vehicle saved = vehicleService.saveVehicle(vehicle);
        return VehicleMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public VehicleDTO updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) {
        vehicleDTO.setId(id);
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDTO);
        Vehicle updated = vehicleService.saveVehicle(vehicle);
        return VehicleMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "Vehicle deleted successfully";
    }
}
