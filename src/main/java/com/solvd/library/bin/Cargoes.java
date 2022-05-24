package com.solvd.library.bin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cargoes {
    @JsonProperty
    private Long id = null;
    @JsonProperty("origins")
    private List<OriginsJson> origin;
    @JsonProperty("nOfItems")
    private int items;
    @JsonProperty("totalWeight")
    private int weight;
    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "mm/dd/yyyy")
    private Date date;  //CHECK this type because i never used it

    public Cargoes(Long id, List<OriginsJson> origin, int items, int weight, Date date) {
        this.id = id;
        this.origin = origin;
        this.items = items;
        this.weight = weight;
        this.date = date;
    }

    public Cargoes(List<OriginsJson> origin, int items, int weight, Date date) {
        this.origin = origin;
        this.items = items;
        this.weight = weight;
        this.date = date;
    }

    public List<OriginsJson> getOrigin() {
        return origin;
    }

    public void setOrigin(List<OriginsJson> origin) {
        this.origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cargoes)) return false;
        Cargoes cargoes = (Cargoes) o;
        return items == cargoes.items && weight == cargoes.weight && Objects.equals(id, cargoes.id) && origin.equals(cargoes.origin) && date.equals(cargoes.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, items, weight, date);
    }

    @Override
    public String toString() {
        return "Cargoes{" +
                "id=" + id +
                ", origin=" + origin +
                ", items=" + items +
                ", weight=" + weight +
                ", date=" + date +
                '}';
    }
}
