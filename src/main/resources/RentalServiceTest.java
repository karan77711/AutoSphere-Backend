package com.vehicle.vehiclerental.service;

import com.vehicle.vehiclerental.entity.Rental;
import com.vehicle.vehiclerental.repository.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RentalServiceTest {

    private RentalRepository rentalRepository;
    private RentalService rentalService;

    @BeforeEach
    void setUp() {
        rentalRepository = Mockito.mock(RentalRepository.class);
        rentalService = new RentalService(rentalRepository);
    }

    @Test
    void testSaveRental() {
        Rental rental = new Rental();
        rental.setId(1L);

        when(rentalRepository.save(rental)).thenReturn(rental);

        Rental saved = rentalService.saveRental(rental);

        assertNotNull(saved);
        assertEquals(1L, saved.getId());
        verify(rentalRepository, times(1)).save(rental);
    }

    @Test
    void testGetRentalById() {
        Rental rental = new Rental();
        rental.setId(1L);

        when(rentalRepository.findById(1L)).thenReturn(Optional.of(rental));

        Rental found = rentalService.getRental(1L);

        assertEquals(1L, found.getId());
        verify(rentalRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllRentals() {
        Rental r1 = new Rental();
        r1.setId(1L);

        when(rentalRepository.findAll()).thenReturn(List.of(r1));

        List<Rental> rentals = rentalService.getAllRentals();

        assertEquals(1, rentals.size());
        assertEquals(1L, rentals.get(0).getId());
    }

    @Test
    void testDeleteRental() {
        when(rentalRepository.existsById(1L)).thenReturn(true);

        rentalService.deleteRental(1L);

        verify(rentalRepository, times(1)).deleteById(1L);
    }
}
