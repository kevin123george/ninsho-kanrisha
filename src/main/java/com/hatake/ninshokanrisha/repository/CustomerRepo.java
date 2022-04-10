package com.hatake.ninshokanrisha.repository;

import com.hatake.ninshokanrisha.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
