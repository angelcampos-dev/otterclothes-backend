package com.otterclothes.api.controllers;

import com.otterclothes.api.models.Address;
import com.otterclothes.api.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        address.setAddressId(null);
        return addressRepository.save(address);
    }
}