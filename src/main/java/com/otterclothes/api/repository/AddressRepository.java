package com.otterclothes.api.repository;

import com.otterclothes.api.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findFirstByUser_UserIdAndDefaultAddressTrue(Integer userId);
}