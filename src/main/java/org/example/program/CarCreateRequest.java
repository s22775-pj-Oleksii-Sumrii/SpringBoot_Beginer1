package org.example.program;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarCreateRequest {
    private String brand;
    private String model;
}
