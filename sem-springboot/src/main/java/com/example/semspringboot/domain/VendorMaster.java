package com.example.semspringboot.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sem_vendor_master")
public class VendorMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "vendor_code", nullable = false, unique = true, length = 20)
    private String vendorCode;

    @NotBlank
    @Size(max = 200)
    @Column(name = "vendor_name", nullable = false, length = 200)
    private String vendorName;

    @Size(max = 20)
    @Column(name = "vendor_type", length = 20)
    private String vendorType;

    @Size(max = 20)
    @Column(name = "tax_id", length = 20)
    private String taxId;

    @Size(max = 10)
    @Column(name = "status", length = 10)
    private String status;

    @Size(max = 120)
    @Column(name = "contact_name", length = 120)
    private String contactName;

    @Size(max = 120)
    @Column(name = "email", length = 120)
    private String email;

    @Size(max = 30)
    @Column(name = "telephone", length = 30)
    private String telephone;

    @Size(max = 30)
    @Column(name = "mobile", length = 30)
    private String mobile;

    @Size(max = 400)
    @Column(name = "address", length = 400)
    private String address;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at")
    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
