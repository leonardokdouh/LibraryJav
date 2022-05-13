package com.solvd.library.bin;

public class Books {
    private Long id = null;

    private String type;

    private Long cargoesId;


    public Books(Long id, String type, Long cargoesId) {
        this.id = id;
        this.type = type;
        this.cargoesId = cargoesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCargoesId() {
        return cargoesId;
    }

    public void setCargoesId(Long cargoesId) {
        this.cargoesId = cargoesId;
    }
}
