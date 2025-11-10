package com.example.semspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.semspringboot.domain.UserAccount;
import com.example.semspringboot.repository.UserAccountRepository;
import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.jpa.show-sql=false",
        "spring.jpa.properties.hibernate.format_sql=false"
})
@Import(UserAccountControllerTest.EmbeddedPostgresConfig.class)
class UserAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Test
    void createAndFetchUser() throws Exception {
        userAccountRepository.deleteAll();

        UserAccount payload = new UserAccount();
        payload.setUsername("demo");
        payload.setDisplayName("Demo User");
        payload.setEmail("demo@example.com");

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isCreated());

        MvcResult listResult = mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andReturn();

        UserAccount[] users = objectMapper.readValue(listResult.getResponse().getContentAsByteArray(), UserAccount[].class);
        assertThat(users).hasSize(1);
        assertThat(users[0].getUsername()).isEqualTo("demo");
    }

    @TestConfiguration
    static class EmbeddedPostgresConfig {

        @Bean(destroyMethod = "close")
        EmbeddedPostgres embeddedPostgres() throws IOException {
            return EmbeddedPostgres.builder()
                    .setPort(0)
                    .start();
        }

        @Bean
        @Primary
        DataSource dataSource(EmbeddedPostgres embeddedPostgres) {
            return embeddedPostgres.getPostgresDatabase().getDataSource();
        }
    }
}
