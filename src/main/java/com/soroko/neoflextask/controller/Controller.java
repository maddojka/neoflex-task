package com.soroko.neoflextask.controller;

import com.soroko.neoflextask.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * This class consists REST API logic
 * @author yuriy.soroko
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(
        name = "Controller",
        description = "Contains only one method to calculate vacation pay"
)
public class Controller {

    final DataService dataService;

    /**
     * @param averageSalary average salary of the employee for the last twelve months
     * @param vacayDays     amount of the days of vacation
     * @return response of the method: if everything is ok response returns calculated value otherwise system
     * returns 418 - I'm teapot
     */
    @GetMapping("/calculate")
    @Operation(summary = "Calculate information about vacation pay of employee")
    public ResponseEntity<Double> calculateVacationPay(
            @Parameter(description = "average salary", example = "620000")
            @RequestParam double averageSalary,
            @Parameter(description = "vacation days", example = "12")
            @RequestParam int vacayDays) {
        if (averageSalary < 0 || vacayDays < 0) {
            return ResponseEntity.status(HttpStatusCode.valueOf(418)).build();
        }
        return ResponseEntity.ok(dataService.vacationPay(averageSalary, vacayDays));
    }
}
