package com.example.semspringboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.semspringboot.domain.VendorMaster;
import com.example.semspringboot.repository.VendorMasterRepository;
import com.example.semspringboot.repository.VendorMasterSpecifications;

@Repository
public class JpaVendorMasterDao implements VendorMasterDao {

    private final VendorMasterRepository vendorMasterRepository;

    JpaVendorMasterDao(VendorMasterRepository vendorMasterRepository) {
        this.vendorMasterRepository = vendorMasterRepository;
    }

    @Override
    public List<VendorMaster> findAll() {
        return vendorMasterRepository.findAll(Sort.by("vendorName").ascending());
    }

    @Override
    public Optional<VendorMaster> findByVendorCode(String vendorCode) {
        if (!StringUtils.hasText(vendorCode)) {
            return Optional.empty();
        }
        Specification<VendorMaster> specification = (root, query, builder) -> builder.equal(
                builder.lower(root.get("vendorCode")), vendorCode.toLowerCase());
        return vendorMasterRepository.findOne(specification);
    }

    @Override
    public List<VendorMaster> search(String vendorCode, String vendorName, String status) {
        Specification<VendorMaster> specification = (root, query, builder) -> builder.conjunction();
        if (StringUtils.hasText(vendorCode)) {
            specification = specification.and(VendorMasterSpecifications.vendorCodeLike(vendorCode));
        }
        if (StringUtils.hasText(vendorName)) {
            specification = specification.and(VendorMasterSpecifications.vendorNameLike(vendorName));
        }
        if (StringUtils.hasText(status)) {
            specification = specification.and(VendorMasterSpecifications.statusEquals(status));
        }
        return vendorMasterRepository.findAll(specification, Sort.by("vendorName").ascending());
    }

    @Override
    @Transactional
    public VendorMaster save(VendorMaster vendorMaster) {
        return vendorMasterRepository.save(vendorMaster);
    }
}
