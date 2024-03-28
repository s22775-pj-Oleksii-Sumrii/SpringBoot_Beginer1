package org.example.program;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public CarResponse createCar(@RequestBody CarCreateRequest request) {
        return carService.createCar(request);
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }
}
