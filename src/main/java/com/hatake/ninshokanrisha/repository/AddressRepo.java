package com.hatake.ninshokanrisha.repository;

import com.hatake.ninshokanrisha.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
