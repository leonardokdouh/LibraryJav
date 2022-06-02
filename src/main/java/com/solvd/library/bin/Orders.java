package com.solvd.library.bin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Orders {
    @JsonProperty
    private Long id;
    @JsonProperty
    private Long customersId;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy")
    private Date date;

    public Orders(Long id, Long customersId, Date date) {
        this.id = id;
        this.customersId = customersId;
        this.date = date;
    }

    public Orders() {

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customersId, date);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", customersId=" + customersId +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) && Objects.equals(customersId, orders.customersId) && Objects.equals(date, orders.date);
    }


}
