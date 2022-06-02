package com.solvd.library.bin;

import java.util.Objects;

public class CargoDetails {

    private Long id = null;

    private Long cargoesId;

    private Long workersId;


    public CargoDetails(Long id, Long cargoesId, Long workersId) {
        this.id = id;
        this.cargoesId = cargoesId;
        this.workersId = workersId;
    }

    public CargoDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCargoesId() {
        return cargoesId;
    }

    public void setCargoesId(Long cargoesId) {
        this.cargoesId = cargoesId;
    }

    public Long getWorkersId() {
        return workersId;
    }

    public void setWorkersId(Long workersId) {
        this.workersId = workersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoDetails)) return false;
        CargoDetails that = (CargoDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(cargoesId, that.cargoesId) && Objects.equals(workersId, that.workersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargoesId, workersId);
    }

    @Override
    public String toString() {
        return "CargoDetails{" +
                "id=" + id +
                ", cargoesId=" + cargoesId +
                ", workersId=" + workersId +
                '}';
    }
}

