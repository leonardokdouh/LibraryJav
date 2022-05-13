package com.solvd.library.bin;

import java.util.Objects;

public class Orders {

    private Long id;


    private Long customersId;

    public Orders(Long id, Long customersId) {
        this.id = id;
        this.customersId = customersId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomersId() {
        return customersId;
    }

    public void setCustomersId(Long customersId) {
        this.customersId = customersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) && Objects.equals(customersId, orders.customersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customersId);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", customersId=" + customersId +
                '}';
    }
}
