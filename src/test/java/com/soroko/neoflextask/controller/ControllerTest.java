package com.soroko.neoflextask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soroko.neoflextask.service.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @Mock
    private Controller controller;

    @InjectMocks
    private DataService dataService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Check status is OK (200) after get request with appropriate data")
    void calculateVacationPay_isOK() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=620000&vacayDays=12"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Check status is I'm a teapot (418) after get request with incorrect data")
    void calculateVacationPay_is418() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=620000&vacayDays=-12"))
                .andExpect(status().is(418));
    }
}