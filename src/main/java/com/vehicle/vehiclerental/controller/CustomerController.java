package com.vehicle.vehiclerental.controller;

import com.vehicle.vehiclerental.dto.CustomerDTO;
import com.vehicle.vehiclerental.entity.Customer;
import com.vehicle.vehiclerental.mapper.CustomerMapper;
import com.vehicle.vehiclerental.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers()
                .stream()
                .map(CustomerMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return CustomerMapper.toDTO(customer);
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        Customer saved = customerService.saveCustomer(customer);
        return CustomerMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        Customer customer = CustomerMapper.toEntity(customerDTO);
        Customer updated = customerService.saveCustomer(customer);
        return CustomerMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}
