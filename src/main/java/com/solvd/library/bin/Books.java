package com.solvd.library.bin;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id) && Objects.equals(type, books.type) && Objects.equals(cargoesId, books.cargoesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, cargoesId);
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", cargoesId=" + cargoesId +
                '}';
    }
}
