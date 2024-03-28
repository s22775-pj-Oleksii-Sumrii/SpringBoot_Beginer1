package org.example.program;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    public CarResponse createCar(CarCreateRequest request) {
        Car car = new Car();
        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        Car savedCar = carRepository.save(car);
        return mapToCarResponse(savedCar);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    private CarResponse mapToCarResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setBrand(car.getBrand());
        response.setModel(car.getModel());
        return response;
    }
}
