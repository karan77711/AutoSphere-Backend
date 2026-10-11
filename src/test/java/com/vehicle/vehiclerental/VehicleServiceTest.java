package com.vehicle.vehiclerental;

import com.vehicle.vehiclerental.entity.Vehicle;
import com.vehicle.vehiclerental.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.vehicle.vehiclerental.service.VehicleService;
import com.vehicle.vehiclerental.service.VehicleService;


class VehicleServiceTest {

    private VehicleRepository vehicleRepository;
    private VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        vehicleRepository = Mockito.mock(VehicleRepository.class);
        vehicleService = new VehicleService(vehicleRepository);
    }

    @Test
    void testSaveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("Toyota");

        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);

        Vehicle saved = vehicleService.saveVehicle(vehicle);

        assertNotNull(saved);
        assertEquals("Toyota", saved.getBrand());
        verify(vehicleRepository, times(1)).save(vehicle);
    }

    @Test
    void testGetVehicleById() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("Honda");

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicle));

        Vehicle found = vehicleService.getVehicle(1L);

        assertEquals("Honda", found.getBrand());
        verify(vehicleRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllVehicles() {
        Vehicle v1 = new Vehicle();
        v1.setId(1L);
        v1.setBrand("BMW");

        when(vehicleRepository.findAll()).thenReturn(List.of(v1));

        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        assertEquals(1, vehicles.size());
        assertEquals("BMW", vehicles.get(0).getBrand());
    }

    @Test
    void testDeleteVehicle() {
        when(vehicleRepository.existsById(1L)).thenReturn(true);

        vehicleService.deleteVehicle(1L);

        verify(vehicleRepository, times(1)).deleteById(1L);
    }
}
