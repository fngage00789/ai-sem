package com.example.semspringboot.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.semspringboot.dao.VendorMasterDao;
import com.example.semspringboot.domain.VendorMaster;

@Service
@Transactional
public class VendorMasterServiceImpl implements VendorMasterService {

    private final VendorMasterDao vendorMasterDao;

    VendorMasterServiceImpl(VendorMasterDao vendorMasterDao) {
        this.vendorMasterDao = vendorMasterDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VendorMaster> search(String vendorCode, String vendorName, String status) {
        return vendorMasterDao.search(vendorCode, vendorName, status);
    }

    @Override
    @Transactional(readOnly = true)
    public VendorMaster getByVendorCode(String vendorCode) {
        return vendorMasterDao.findByVendorCode(vendorCode)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor with code " + vendorCode + " was not found"));
    }

    @Override
    public VendorMaster create(VendorMaster vendorMaster) {
        vendorMaster.setId(null);
        vendorMaster.setCreatedAt(Instant.now());
        vendorMaster.setUpdatedAt(null);
        vendorMaster.setStatus(normalizeStatus(vendorMaster.getStatus()));
        return vendorMasterDao.save(vendorMaster);
    }

    @Override
    public VendorMaster update(String vendorCode, VendorMaster vendorMaster) {
        VendorMaster existing = getByVendorCode(vendorCode);
        if (vendorMaster.getVendorCode() != null
                && !vendorCode.equalsIgnoreCase(vendorMaster.getVendorCode())) {
            throw new InvalidRequestException("Vendor code cannot be changed through this endpoint");
        }
        existing.setVendorName(vendorMaster.getVendorName());
        existing.setVendorType(vendorMaster.getVendorType());
        existing.setTaxId(vendorMaster.getTaxId());
        existing.setStatus(normalizeStatus(vendorMaster.getStatus()));
        existing.setContactName(vendorMaster.getContactName());
        existing.setEmail(vendorMaster.getEmail());
        existing.setTelephone(vendorMaster.getTelephone());
        existing.setMobile(vendorMaster.getMobile());
        existing.setAddress(vendorMaster.getAddress());
        existing.setUpdatedAt(Instant.now());
        return vendorMasterDao.save(existing);
    }

    private String normalizeStatus(String status) {
        return status != null ? status.trim().toUpperCase() : null;
    }
}
