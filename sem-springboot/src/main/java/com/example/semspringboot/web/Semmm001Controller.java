package com.example.semspringboot.web;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.semspringboot.domain.VendorMaster;
import com.example.semspringboot.service.VendorMasterService;

@RestController
@RequestMapping("/api/semmm001/vendors")
public class Semmm001Controller {

    private final VendorMasterService vendorMasterService;

    public Semmm001Controller(VendorMasterService vendorMasterService) {
        this.vendorMasterService = vendorMasterService;
    }

    @GetMapping
    public List<VendorMaster> searchVendors(@RequestParam(value = "code", required = false) String vendorCode,
            @RequestParam(value = "name", required = false) String vendorName,
            @RequestParam(value = "status", required = false) String status) {
        return vendorMasterService.search(vendorCode, vendorName, status);
    }

    @GetMapping("/{vendorCode}")
    public VendorMaster getVendor(@PathVariable String vendorCode) {
        return vendorMasterService.getByVendorCode(vendorCode);
    }

    @PostMapping
    public ResponseEntity<VendorMaster> createVendor(@Valid @RequestBody VendorMaster vendorMaster) {
        VendorMaster created = vendorMasterService.create(vendorMaster);
        return ResponseEntity.created(URI.create("/api/semmm001/vendors/" + created.getVendorCode())).body(created);
    }

    @PutMapping("/{vendorCode}")
    public VendorMaster updateVendor(@PathVariable String vendorCode, @Valid @RequestBody VendorMaster vendorMaster) {
        return vendorMasterService.update(vendorCode, vendorMaster);
    }
}
