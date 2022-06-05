package com.solvd.library.bin;

import java.util.Objects;

public class ShippingType {

    private Long id = null;
    private String type;

    public ShippingType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public ShippingType() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingType)) return false;
        ShippingType that = (ShippingType) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "ShippingType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
