package com.example.semspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.semspringboot.domain.VendorMaster;

public interface VendorMasterRepository extends JpaRepository<VendorMaster, Long>,
        JpaSpecificationExecutor<VendorMaster> {
}
