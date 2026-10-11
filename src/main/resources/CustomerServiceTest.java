package com.vehicle.vehiclerental.service;

import com.vehicle.vehiclerental.entity.Customer;
import com.vehicle.vehiclerental.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer saved = customerService.saveCustomer(customer);

        assertNotNull(saved);
        assertEquals("John Doe", saved.getName());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Jane Doe");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer found = customerService.getCustomer(1L);

        assertEquals("Jane Doe", found.getName());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllCustomers() {
        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setName("Alice");

        when(customerRepository.findAll()).thenReturn(List.of(c1));

        List<Customer> customers = customerService.getAllCustomers();

        assertEquals(1, customers.size());
        assertEquals("Alice", customers.get(0).getName());
    }

    @Test
    void testDeleteCustomer() {
        when(customerRepository.existsById(1L)).thenReturn(true);

        customerService.deleteCustomer(1L);

        verify(customerRepository, times(1)).deleteById(1L);
    }
}
