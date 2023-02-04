package com.customersupport.customersupport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSupportRepository extends JpaRepository<SupportTask, Integer> {

    List<SupportTask> findByCustomerId(int customerId);

}
