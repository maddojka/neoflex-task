package com.soroko.neoflextask.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 *
 *  This class consists logic of calculation
 * @author yuriy.soroko
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataService {

    /**
     *
     * @param averageSalary average salary of the employee for the last twelve months
     * @param vacayDays amount of the days of vacation
     * @return returns calculated value
     */
    public Double vacationPay(double averageSalary, int vacayDays) {
        return Math.round(averageSalary / (12 * 29.3) * vacayDays * 0.87 * 100.0) / 100.0;
    }
}
