package com.example.semspringboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.semspringboot.domain.VendorMaster;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;

@SpringBootTest
@AutoConfigureMockMvc
class Semmm001ControllerTest {

    private static EmbeddedPostgres embeddedPostgres;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterAll
    static void stopEmbeddedPostgres() throws IOException {
        if (embeddedPostgres != null) {
            embeddedPostgres.close();
        }
    }

    @DynamicPropertySource
    static void registerDataSourceProperties(DynamicPropertyRegistry registry) throws IOException {
        if (embeddedPostgres == null) {
            embeddedPostgres = EmbeddedPostgres.builder().setPort(0).start();
        }
        registry.add("spring.datasource.url", () -> embeddedPostgres.getJdbcUrl("postgres", "postgres"));
        registry.add("spring.datasource.username", () -> "postgres");
        registry.add("spring.datasource.password", () -> "postgres");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @Test
    void createUpdateAndFetchVendor() throws Exception {
        VendorMaster payload = buildVendor("V0001", "SEMMM Vendor", "ACTIVE");

        mockMvc.perform(post("/api/semmm001/vendors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.vendorCode").value("V0001"))
                .andExpect(jsonPath("$.vendorName").value("SEMMM Vendor"))
                .andExpect(jsonPath("$.status").value("ACTIVE"));

        VendorMaster updatePayload = buildVendor("V0001", "SEMMM Vendor Updated", "INACTIVE");

        mockMvc.perform(put("/api/semmm001/vendors/{vendorCode}", "V0001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatePayload)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendorName").value("SEMMM Vendor Updated"))
                .andExpect(jsonPath("$.status").value("INACTIVE"));

        mockMvc.perform(get("/api/semmm001/vendors/{vendorCode}", "V0001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendorName").value("SEMMM Vendor Updated"))
                .andExpect(jsonPath("$.status").value("INACTIVE"));

        mockMvc.perform(get("/api/semmm001/vendors").param("name", "updated"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].vendorCode").value("V0001"))
                .andExpect(jsonPath("$[0].vendorName").value("SEMMM Vendor Updated"));
    }

    private VendorMaster buildVendor(String code, String name, String status) {
        VendorMaster vendorMaster = new VendorMaster();
        vendorMaster.setVendorCode(code);
        vendorMaster.setVendorName(name);
        vendorMaster.setStatus(status);
        vendorMaster.setVendorType("LOCAL");
        vendorMaster.setTaxId("1234567890123");
        vendorMaster.setContactName("Tester");
        vendorMaster.setEmail("tester@example.com");
        vendorMaster.setTelephone("021234567");
        vendorMaster.setMobile("0812345678");
        vendorMaster.setAddress("123 Test Street");
        vendorMaster.setCreatedAt(null);
        vendorMaster.setUpdatedAt(null);
        return vendorMaster;
    }
}
