package com.example.semspringboot.dao;

import java.util.List;
import java.util.Optional;

import com.example.semspringboot.domain.VendorMaster;

public interface VendorMasterDao {

    List<VendorMaster> findAll();

    Optional<VendorMaster> findByVendorCode(String vendorCode);

    List<VendorMaster> search(String vendorCode, String vendorName, String status);

    VendorMaster save(VendorMaster vendorMaster);
}
