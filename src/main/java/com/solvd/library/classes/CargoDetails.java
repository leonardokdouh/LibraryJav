package com.solvd.library.classes;

public class CargoDetails {

    private Long id=null;

    private Long cargoesId;

    private Long workersId;


    public CargoDetails(Long id, Long cargoesId, Long workersId) {
        this.id = id;
        this.cargoesId = cargoesId;
        this.workersId = workersId;
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
}
