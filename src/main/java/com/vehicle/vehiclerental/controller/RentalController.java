package com.vehicle.vehiclerental.controller;

import com.vehicle.vehiclerental.dto.RentalDTO;
import com.vehicle.vehiclerental.entity.Rental;
import com.vehicle.vehiclerental.mapper.RentalMapper;
import com.vehicle.vehiclerental.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
@CrossOrigin(origins = "http://localhost:5173")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<RentalDTO> getAllRentals() {
        return rentalService.getAllRentals()
                .stream()
                .map(RentalMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public RentalDTO getRental(@PathVariable Long id) {
        Rental rental = rentalService.getRental(id);
        return RentalMapper.toDTO(rental);
    }

    @PostMapping
    public ResponseEntity<RentalDTO> addRental(@RequestBody RentalDTO rentalDTO) {
        Rental rental = RentalMapper.toEntity(rentalDTO);
        Rental saved = rentalService.saveRental(rental);
        return ResponseEntity.ok(RentalMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDTO> updateRental(@PathVariable Long id, @RequestBody RentalDTO rentalDTO) {
        rentalDTO.setId(id);
        Rental rental = RentalMapper.toEntity(rentalDTO);
        Rental updated = rentalService.saveRental(rental);
        return ResponseEntity.ok(RentalMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.ok("Rental deleted successfully");
    }
}
