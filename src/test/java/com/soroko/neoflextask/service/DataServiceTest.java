package com.soroko.neoflextask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataServiceTest {

    @Autowired
    private DataService dataService;

    @Test
    @DisplayName("Check calculation of the vacation pay of the employee")
    void vacationPay() {
        double vacationPay = dataService.vacationPay(620_000.0, 12);
        Assertions.assertEquals(vacationPay, 18409.56);
    }
}