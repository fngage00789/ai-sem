package com.example.semspringboot.repository;

import org.springframework.data.jpa.domain.Specification;

import com.example.semspringboot.domain.VendorMaster;

public final class VendorMasterSpecifications {

    private VendorMasterSpecifications() {
    }

    public static Specification<VendorMaster> vendorCodeLike(String vendorCode) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("vendorCode")), likePattern(vendorCode));
    }

    public static Specification<VendorMaster> vendorNameLike(String vendorName) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("vendorName")), likePattern(vendorName));
    }

    public static Specification<VendorMaster> statusEquals(String status) {
        return (root, query, builder) -> builder.equal(builder.upper(root.get("status")), status.toUpperCase().trim());
    }

    private static String likePattern(String input) {
        return "%" + input.toLowerCase().trim() + "%";
    }
}
