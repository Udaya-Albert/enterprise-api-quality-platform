package com.framework.builders;

import com.framework.models.request.EmployeeRequest;
import com.framework.utils.TestDataGenerator;

import java.util.UUID;

public class EmployeeRequestBuilder {

    private EmployeeRequestBuilder() {
    }

    public static EmployeeRequest buildEmployee() {

        return EmployeeRequest.builder()

                .firstName("John")

                .lastName("Architect")

                .employeeId(
                		TestDataGenerator.randomEmployeeId())

                .build();
    }
}