package com.example.mssbilling.repositories;

import com.example.mssbilling.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,String> {
    List<Bill> findByCustomerId(String id);
}
