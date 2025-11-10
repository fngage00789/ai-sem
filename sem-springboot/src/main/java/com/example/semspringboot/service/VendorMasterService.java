package com.example.semspringboot.service;

import java.util.List;

import com.example.semspringboot.domain.VendorMaster;

public interface VendorMasterService {

    List<VendorMaster> search(String vendorCode, String vendorName, String status);

    VendorMaster getByVendorCode(String vendorCode);

    VendorMaster create(VendorMaster vendorMaster);

    VendorMaster update(String vendorCode, VendorMaster vendorMaster);
}
