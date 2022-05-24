package com.solvd.library.bin;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OriginsJson {
    @JsonProperty
    private String city;

    @JsonProperty
    private String country;

    public OriginsJson(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OriginsJson)) return false;
        OriginsJson that = (OriginsJson) o;
        return Objects.equals(city, that.city) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "OriginsJson{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
